package com.example.back.receiver;

public class EditDevice {
    String op;
    String id;
    String content;

    public void setOp(String op){
        this.op=op;
    }
    public String getOp(){
        return this.op;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return this.content;
    }
}
