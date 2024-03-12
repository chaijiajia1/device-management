package com.example.back.service;
import com.example.back.DAO.userDAO;
import com.example.back.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service  //indicate that this class is a service component in Spring, 给DAO.UserDAO提供服务
public class UserService {
    @Autowired
    userDAO user_dao;  //inject an instance of userDAO
    public boolean isExist(String username){
        return user_dao.findByUsername(username)==null;
    }
    public User getByName(String username){
        return user_dao.findByUsername(username);
    }
    public User getByEmail(String email){return user_dao.getUserByEmail(email);}
    public User get(String username,String password){
        return user_dao.getByUsernameAndPassword(username,password);
    }
    public boolean verifyEmail(String email){
        //return true;//TODO
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
//            ^：匹配字符串的开始。
//[a-zA-Z0-9._%+-]+：匹配电子邮件的用户名部分。用户名可以包含字母（大写或小写）、数字、点、下划线、百分号、加号或减号。
//            @：匹配@字符。
//[a-zA-Z0-9.-]+：匹配电子邮件的域名部分，但不包括顶级域。这部分可以包含字母（大写或小写）、数字、点或连字符。
//\.：匹配点字符。
//[a-zA-Z]{2,}：匹配电子邮件的顶级域（如.com、.org、.net）。这里假设顶级域至少有两个字符长。
//            $：匹配字符串的结束。
            //System.err.println("Format error");
            return false;
        }
        return true;
    }
    public void add(User user){
        user_dao.save(user);
    }
}
