package com.again.peace.myfirstwebapp.login;

import com.again.peace.myfirstwebapp.user.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public Boolean checkMdp(User user){

        if (user.getName().contains("a")){return Boolean.FALSE;}
        return Boolean.TRUE;
    }
}
