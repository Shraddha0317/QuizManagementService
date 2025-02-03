package com.Innobyte.QuizManagementService.controller;



import com.Innobyte.QuizManagementService.entities.QuizAttempt;
import com.Innobyte.QuizManagementService.repositories.QuizAttemptRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {
    private final QuizAttemptRepository repository;

    public LeaderboardController(QuizAttemptRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/top")
    public List<QuizAttempt> getTopScorers() {
        return repository.findAll().stream()
                .sorted((a, b) -> b.getScore() - a.getScore())
                .limit(10)
                .toList();
    }
}
