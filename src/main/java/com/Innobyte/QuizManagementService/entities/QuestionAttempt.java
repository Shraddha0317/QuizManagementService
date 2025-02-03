package com.Innobyte.QuizManagementService.entities;

import lombok.Data;

@Data
public class QuestionAttempt {
    private String questionId;
    private String selectedAnswer;
    private boolean isCorrect;
}
