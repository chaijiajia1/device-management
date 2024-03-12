package com.example.back.Controller;
import com.example.back.Device;
import com.example.back.receiver.CreateDevice;
import com.example.back.result;
import com.example.back.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateController {

    @Autowired
    DeviceService device_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value = "api/create")
    //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public result edit(@RequestBody CreateDevice create_device) {
        //System.out.println("");
        String id=create_device.getId();
        String name=create_device.getName();
        String type=create_device.getType();
        String username=create_device.getUsername();
        if(device_service.getByID(id)!=null){
            return new result(400);
        }
        device_service.add(id,name,type,username);
        return new result(200);
    }
}


