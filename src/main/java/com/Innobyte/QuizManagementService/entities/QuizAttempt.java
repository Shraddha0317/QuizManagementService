package com.Innobyte.QuizManagementService.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "quiz_attempts")
public class QuizAttempt {
    @Id
    private String id;
    private String userId;
    private String quizId;
    private List<QuestionAttempt> questionAttempts = new ArrayList<>();  // Initialize here
    private int score;
    private boolean completed;
}
