package com.Innobyte.QuizManagementService.repositories;

import com.Innobyte.QuizManagementService.entities.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    Optional<Quiz> findByTitle(String title);
}

