package com.microservices.quiz_service.service;


import com.microservices.quiz_service.dao.QuizDao;
import com.microservices.quiz_service.feign.QuizInterface;
import com.microservices.quiz_service.model.QuestionWrapper;
import com.microservices.quiz_service.model.Quiz;
import com.microservices.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        // calls the generate URL
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);


        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        quizInterface.getQuestionsFromId(questionIds);
        ResponseEntity <List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);


        return  questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){

        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}
