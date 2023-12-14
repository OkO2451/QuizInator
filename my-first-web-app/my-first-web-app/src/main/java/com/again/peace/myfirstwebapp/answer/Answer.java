package com.again.peace.myfirstwebapp.answer;

import com.again.peace.myfirstwebapp.question.Question;
import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String answerId;
    private String sessionId;
    private String questionId;
    private int chosenOption;
    private boolean isCorrect;
    private int timeTaken;

    @ManyToOne
    private Question question;
}
