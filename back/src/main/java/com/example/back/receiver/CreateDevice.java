package com.example.back.receiver;

public class CreateDevice {
    String id;
    String name;
    String type;
    String username;

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
    public void setUsername(String username){this.username=username;}
    public String getUsername(){return this.username;}
}
