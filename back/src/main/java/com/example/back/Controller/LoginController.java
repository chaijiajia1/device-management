package com.example.back.Controller;
import com.example.back.User;
import com.example.back.result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import java.util.Objects;
import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class LoginController {

    @Autowired
    UserService user_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value= "api/login")  //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public result login(@RequestBody User user){
        System.out.println("login");
        String username = user.getUsername();
        username=HtmlUtils.htmlEscape(username); //escapes special characters in a given string to prevent Cross-Site Scripting (XSS) attacks.
        if(user_service.get(username,user.getPassword())==null){
            if(user_service.getByName(username)==null) return new result(400);
            else return new result(401);
        }
        else {System.out.println("yes");return new result(200);}
    }
}
