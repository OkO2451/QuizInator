package com.again.peace.myfirstwebapp.session;

import com.again.peace.myfirstwebapp.user.Enseignant;
import com.again.peace.myfirstwebapp.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coursID;
    private String title;
    private String Description;
    private  String Contenu;
    @ManyToOne
    private User enseignant;
    @OneToMany(mappedBy = "cours")
    private List<Quizz> quizs;

}
