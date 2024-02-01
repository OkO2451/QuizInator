package com.again.peace.myfirstwebapp.user;

import com.again.peace.myfirstwebapp.session.Quizz;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String username;
    private String password;
    private String email;
    private Date createdAt;
    private Date lastLogin;

    public String getName(){
        return username;
    }





    @Override
    public String toString() {
        return super.toString();
    }
}
