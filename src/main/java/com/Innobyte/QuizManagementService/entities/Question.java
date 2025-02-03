package com.Innobyte.QuizManagementService.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
public class Question {
    @Id
    private String id;

    private String title;
    private List<String> options;
    private String correctAnswer;



//    public Object getId() {
//        return
//    }
}
