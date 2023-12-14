package com.again.peace.myfirstwebapp.question;

import com.again.peace.myfirstwebapp.answer.Answer;
import com.again.peace.myfirstwebapp.session.Session;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String questionId;
    private String quizType;
    private String difficultyLevel;
    private String questionText;
    @OneToMany(mappedBy = "question")
    private List<Answer> options;
    private int correctOption;

    @ManyToOne
    private Session session;
}
