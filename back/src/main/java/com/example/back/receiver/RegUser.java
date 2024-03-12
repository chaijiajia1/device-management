package com.example.back.receiver;

import com.example.back.User;

public class RegUser {
    User user;
    String passwordRe;
    public void setUser(User user){this.user=user;}
    public User getUser(){return this.user;}
    public void setPasswordRe(String ps){this.passwordRe=ps;}
    public String getPasswordRe(){return this.passwordRe;}
}
