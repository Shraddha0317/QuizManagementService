package com.Innobyte.QuizManagementService.repositories;

import com.Innobyte.QuizManagementService.entities.QuizAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface QuizAttemptRepository extends MongoRepository<QuizAttempt, String> {
    List<QuizAttempt> findByUserId(String userId);
}
