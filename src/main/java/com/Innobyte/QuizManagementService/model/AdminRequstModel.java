package com.Innobyte.QuizManagementService.model;

import com.Innobyte.QuizManagementService.entities.Question;
import lombok.Data;

import java.util.List;
@Data
public class AdminRequstModel {



    private String QuizId;
    private String title;
    private List<Question> questions;
}
