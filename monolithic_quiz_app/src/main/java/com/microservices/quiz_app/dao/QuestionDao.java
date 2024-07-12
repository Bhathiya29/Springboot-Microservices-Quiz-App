package com.microservices.quiz_app.dao;

import com.microservices.quiz_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository <Question,Integer> {

   List<Question> findByCategory(String category);

   @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
   List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("num") int num);
}
