package com.again.peace.myfirstwebapp.session;

import com.again.peace.myfirstwebapp.question.Question;
import com.again.peace.myfirstwebapp.user.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String sessionId;
    private String userId;
    private String quizType;
    private String difficultyLevel;
    private int timeLimit;
    private Date startTime;
    private Date endTime;
    private int score;

    @OneToMany
    private List<User> userList;

    @OneToMany(mappedBy = "session")
    private List<Question> questions;
}
