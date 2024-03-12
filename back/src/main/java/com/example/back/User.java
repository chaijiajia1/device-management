package com.example.back;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity  //indicate that this class is an entity and should be mapped to a database table
@Table(name = "user")  //specify the name of the database table
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"}) //因为是做前后端分离，而前后端数据交互用的是 json 格式。 那么 User 对象就会被转换为 json 数据。 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate, 在 jpa 工作过程中，就会创造代理类来继承 User ，并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。但是没看懂
public class User {
    @Id  //不是表里的id，而是指明主键
    String email;
    String username;
    String password;


    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
}
