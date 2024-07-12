package com.microservices.quiz_service.controller;


import com.microservices.quiz_service.model.QuestionWrapper;
import com.microservices.quiz_service.model.QuizDto;
import com.microservices.quiz_service.model.Response;
import com.microservices.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping(path = "create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());

    }

    @GetMapping(path = "get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuestions(id);
    }

    @PostMapping(path = "submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
