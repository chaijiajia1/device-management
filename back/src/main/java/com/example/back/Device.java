package com.example.back;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name="device")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Device {
    @Id
    String device_id;
    String name;
    String type;
    String username;
    String active;

    public Device(String device_id, String name, String type, String username) {
        this.device_id=device_id;
        this.name=name;
        this.type=type;
        this.username=username;
        this.active=null;
    }
    public Device(String device_id) {
        this.device_id=device_id;
        this.name=null;
        this.type=null;
        this.username=null;
        this.active=null;
    }
    public Device() {
        this.device_id=null;
        this.name=null;
        this.type=null;
        this.username=null;
        this.active=null;
    }
    public String getDevice_id(){
        return this.device_id;
    }
    public void setDevice_id(String device_id){
        this.device_id=device_id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setActive(String active){
        this.active=active;
    }
    public String getActive(){
        return this.active;
    }
}
