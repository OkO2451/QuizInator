package com.again.peace.myfirstwebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class LeaderBoardEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private int score;
    private String quizType;
    private Date timestamp;
}
