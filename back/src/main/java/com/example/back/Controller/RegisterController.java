
package com.example.back.Controller;
        import com.example.back.receiver.RegUser;
        import com.example.back.User;
        import com.example.back.result;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.util.HtmlUtils;
        import com.example.back.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class RegisterController {

    @Autowired
    UserService user_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value= "api/register")  //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public result register(@RequestBody RegUser register){
        //System.out.println("");
        User user=register.getUser();
        String username = user.getUsername();
        username= HtmlUtils.htmlEscape(username); //escapes special characters in a given string to prevent Cross-Site Scripting (XSS) attacks.
        if(user_service.verifyEmail(user.getEmail())==false){
            return new result(400);
        }
        else if(user_service.getByEmail(user.getEmail())!=null){
            return new result(401);
        }
        else if(user.getEmail().length()<6){
            return new result(402);
        }
        else if(user_service.getByName(user.getUsername())!=null){
            return new result(403);
        }
        else if(user.getPassword().length()<6){
            return new result(404);
        }
        else if(!user.getPassword().equals(register.getPasswordRe())){
            //System.out.println(user.getPassword());
            //System.out.println(register.getPasswordRe());
            return new result(405);
        }
        else {user_service.add(user);return new result(200);}
    }
}
