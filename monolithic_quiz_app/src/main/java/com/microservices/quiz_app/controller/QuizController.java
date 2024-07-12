package com.microservices.quiz_app.controller;

import com.microservices.quiz_app.model.Question;
import com.microservices.quiz_app.model.QuestionWrapper;
import com.microservices.quiz_app.model.Response;
import com.microservices.quiz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping(path = "create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);

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
