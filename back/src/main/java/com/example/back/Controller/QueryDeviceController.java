package com.example.back.Controller;
import java.util.ArrayList;
import com.example.back.message;
import com.example.back.receiver.EditDevice;
import com.example.back.result;
import com.example.back.service.DeviceService;
import com.example.back.service.MessageServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
@Controller
public class QueryDeviceController {
    @Autowired
    DeviceService device_service;
    @Autowired
    MessageServer message_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value = "api/queryDevice")
    //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public ArrayList<Integer> queryDevice() {
        int num1=device_service.getNum();
        int num2=device_service.getActiveNum();
        int num3=message_service.getNum();
        ArrayList<Integer> ret=new ArrayList<>();
            ret.add(num1);
            ret.add(num2);
            ret.add(num3);
        return ret;
    }
}
