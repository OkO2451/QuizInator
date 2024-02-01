package com.again.peace.myfirstwebapp.session;

import com.again.peace.myfirstwebapp.user.Etudiant;
import com.again.peace.myfirstwebapp.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classeId;
    @ManyToMany
    List<User> etudiants;


}
