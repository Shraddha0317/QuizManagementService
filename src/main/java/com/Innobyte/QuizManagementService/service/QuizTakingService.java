package com.Innobyte.QuizManagementService.service;

import com.Innobyte.QuizManagementService.entities.Quiz;
import com.Innobyte.QuizManagementService.entities.QuizAttempt;
import com.Innobyte.QuizManagementService.entities.QuestionAttempt;
import com.Innobyte.QuizManagementService.repositories.QuizAttemptRepository;
import com.Innobyte.QuizManagementService.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class QuizTakingService {
    private final QuizAttemptRepository quizAttemptRepository;
    private final QuizRepository quizRepository;

    public QuizTakingService(QuizAttemptRepository quizAttemptRepository, QuizRepository quizRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
        this.quizRepository = quizRepository;
    }

    public QuizAttempt startQuiz(String userId, String quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isEmpty()) {
            throw new RuntimeException("Quiz not found");
        }

        QuizAttempt quizAttempt = new QuizAttempt();
        quizAttempt.setUserId(userId);
        quizAttempt.setQuizId(quizId);
        quizAttempt.setCompleted(false);
        quizAttemptRepository.save(quizAttempt);
        return quizAttempt;
    }

    public QuizAttempt submitAnswer(String attemptId, String questionId, String selectedAnswer) {
        QuizAttempt attempt = quizAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        Quiz quiz = quizRepository.findById(attempt.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        var question = quiz.getQuestions().stream()
                .filter(q -> q.getId().equals(questionId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Check if the question was already answered
        boolean alreadyAnswered = attempt.getQuestionAttempts().stream()
                .anyMatch(qa -> qa.getQuestionId().equals(questionId));

        if (alreadyAnswered) {
            throw new RuntimeException("This question has already been answered.");
        }

        boolean isCorrect = question.getCorrectAnswer().equals(selectedAnswer);

        QuestionAttempt questionAttempt = new QuestionAttempt();
        questionAttempt.setQuestionId(questionId);
        questionAttempt.setSelectedAnswer(selectedAnswer);
        questionAttempt.setCorrect(isCorrect);

        // Initialize if null
        if (attempt.getQuestionAttempts() == null) {
            attempt.setQuestionAttempts(new ArrayList<>());
        }

        attempt.getQuestionAttempts().add(questionAttempt);

        if (isCorrect) {
            attempt.setScore(attempt.getScore() + 1);
        }

        // Check if all unique questions have been answered
        if (attempt.getQuestionAttempts().size() == quiz.getQuestions().size()) {
            attempt.setCompleted(true);
        }

        quizAttemptRepository.save(attempt);
        return attempt;
    }


}
