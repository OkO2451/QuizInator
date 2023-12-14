package com.again.peace.myfirstwebapp;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("user")
public class MainControler {

    // /api/user
    @RequestMapping("/user")
    public String user(ModelMap model){
        return (String) model.get("user");
    }


}
