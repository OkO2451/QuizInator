package com.again.peace.myfirstwebapp.user;

import com.again.peace.myfirstwebapp.session.Classe;
import com.again.peace.myfirstwebapp.session.Quizz;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class Etudiant extends User {
    @ManyToMany
    private List<Classe> classes;
    private List<Quizz> quizesPris;
}
