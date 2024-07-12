package com.microservices.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "quiz_question",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    // Optionally, add methods for accessing question IDs
    public List<Integer> getQuestionIds() {
        return questions.stream()
                .map(Question::getId)  // Assuming Question has a getId() method
                .collect(Collectors.toList());
    }}

