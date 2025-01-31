package com.Innobyte.QuizManagementService.entities;

import lombok.Data;

import java.util.List;


@Data
public class Question {


    private String title;
    private List<String> options;
    private String correctAnswer;
}
