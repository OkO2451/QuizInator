package com.again.peace.myfirstwebapp.user;

import com.again.peace.myfirstwebapp.session.Cours;
import com.again.peace.myfirstwebapp.session.Quizz;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Enseignant extends User{
    @OneToMany(mappedBy = "enseignant")
    private List<Cours> coursDep;
    private List<Quizz> quizesDeposé;
    private List<Cours> coursdepose;

}
