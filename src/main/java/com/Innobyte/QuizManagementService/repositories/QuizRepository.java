package com.Innobyte.QuizManagementService.repositories;

import com.Innobyte.QuizManagementService.entities.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
}

