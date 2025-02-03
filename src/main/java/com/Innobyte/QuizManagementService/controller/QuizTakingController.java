package com.Innobyte.QuizManagementService.controller;

import com.Innobyte.QuizManagementService.entities.QuizAttempt;
import com.Innobyte.QuizManagementService.service.QuizTakingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz-taking")
public class QuizTakingController {
    private final QuizTakingService quizTakingService;

    public QuizTakingController(QuizTakingService quizTakingService) {
        this.quizTakingService = quizTakingService;
    }

    @PostMapping("/start/{quizId}")
    public ResponseEntity<QuizAttempt> startQuiz(@RequestHeader("Authorization") String token, @PathVariable String quizId) {
        String userId = extractUserIdFromToken(token);
        return ResponseEntity.ok(quizTakingService.startQuiz(userId, quizId));
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizAttempt> submitAnswer(@RequestParam String attemptId, @RequestParam String questionId, @RequestParam String answer) {
        return ResponseEntity.ok(quizTakingService.submitAnswer(attemptId, questionId, answer));
    }

    private String extractUserIdFromToken(String token) {
        return "decodedUserId"; // Replace with actual JWT decoding logic
    }
}
