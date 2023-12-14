package com.again.peace.myfirstwebapp.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> userList = new ArrayList<>();

    UserService(UserRepository userRepository ){
        this.userRepository = userRepository;
        
    }
    private UserRepository userRepository;
    public Boolean addUser(){
        return Boolean.TRUE;
    }
}
