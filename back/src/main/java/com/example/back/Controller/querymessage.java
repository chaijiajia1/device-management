package com.example.back.Controller;
import com.example.back.message;

import com.example.back.receiver.querymessage_;

import com.example.back.service.MessageServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class querymessage {
    @Autowired
    MessageServer message_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value = "api/querymessage")
    //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public ArrayList<String> querymessage(@RequestBody querymessage_ query) {
        String id=query.getId();
        //System.out.println(id);
        List<message> messageRET= message_service.getByDevice_id(id);
        ArrayList<String> ret=new ArrayList<>();
        for (message message : messageRET) {
            // Assuming the Message object has a method called getFirstElement() that returns the required string.
            ret.add(message.getMessage());
        }
        return ret;

    }
}
