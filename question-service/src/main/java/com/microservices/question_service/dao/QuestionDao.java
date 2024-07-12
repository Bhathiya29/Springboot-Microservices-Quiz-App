package com.microservices.question_service.dao;


import com.microservices.question_service.model.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository <Question,Integer> {

   List<Question> findByCategory(String category);

   @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
   List<Integer> findRandomQuestionsByCategory( String category,  int num);
}
