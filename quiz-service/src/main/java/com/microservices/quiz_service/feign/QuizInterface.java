package com.microservices.quiz_service.feign;

import com.microservices.quiz_service.model.QuestionWrapper;
import com.microservices.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    // Generate
    @GetMapping(path = "question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions);

    // Give the questions for the Quiz (questionId)
    @PostMapping(path = "question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds);

    // Get Score
    @PostMapping(path = "question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
