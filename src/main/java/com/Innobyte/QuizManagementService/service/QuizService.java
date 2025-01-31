package com.Innobyte.QuizManagementService.service;


import com.Innobyte.QuizManagementService.entities.Quiz;
import com.Innobyte.QuizManagementService.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;



    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }


    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(String id) {
        return quizRepository.findById(id);
    }

    public Quiz updateQuiz(String id, Quiz updatedQuiz) {
        return quizRepository.findById(id)
                .map(quiz -> {
                    quiz.setTitle(updatedQuiz.getTitle());
                    quiz.setQuestions(updatedQuiz.getQuestions());
                    return quizRepository.save(quiz);
                }).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    public void deleteQuiz(String id) {
        quizRepository.deleteById(id);
    }

}


