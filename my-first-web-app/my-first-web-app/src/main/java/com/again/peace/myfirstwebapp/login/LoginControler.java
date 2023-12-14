package com.again.peace.myfirstwebapp.login;

import com.again.peace.myfirstwebapp.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
@SessionAttributes("user")
public class LoginControler {
    public LoginControler(AuthService authService) {
        this.authService = authService;
    }

    AuthService authService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("log")
    @ResponseBody
    public String gotoLogin(){
        return "ok";
    }



    @PostMapping("model")
    public String model(@RequestBody User user){
        logger.info("\n\ninfo {}: {}\n\n", user.getName(), user.getPassword());
        String name = user.getName() + " ok ";
        if(authService.checkMdp(user)){
            return user.toString();
        }
        return "boooo";
    }

    @RequestMapping("/")
    public String deflt(ModelMap map){
        map.put("user",getLoggedInUserName());
        return "lol";
    }

    private String getLoggedInUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
