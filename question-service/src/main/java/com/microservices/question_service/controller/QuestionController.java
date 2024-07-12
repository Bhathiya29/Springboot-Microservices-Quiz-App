package com.microservices.question_service.controller;



import com.microservices.question_service.model.Question;
import com.microservices.question_service.model.QuestionWrapper;
import com.microservices.question_service.model.Response;
import com.microservices.question_service.service.QuestionService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping(path = "allquestions")
    public ResponseEntity<List<Question>>  getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping(path = "category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // Generate
    @GetMapping(path = "generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz( String categoryName,Integer numQuestions){
       return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    };

    // Give the questions for the Quiz (questionId)
    @PostMapping(path = "getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    // Get Score
    @PostMapping(path = "getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }



}
