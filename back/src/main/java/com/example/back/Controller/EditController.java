package com.example.back.Controller;
import com.example.back.Device;
import com.example.back.receiver.EditDevice;
import com.example.back.result;
import com.example.back.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EditController {

    @Autowired
    DeviceService device_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value = "api/edit")
    //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public result edit(@RequestBody EditDevice edit_device) {
        //System.out.println("edit");
        String op = edit_device.getOp();
        String id=edit_device.getId();
        String content=edit_device.getContent();
        if(device_service.getByID(id)==null){
            return new result(400);
        }
        if(op.equals("name")){
            device_service.setName(content,id);
        }
        else if(op.equals("type")){
            device_service.setType(content,id);
        }
        else if(op.equals("username")){
            device_service.setUsername(content,id);
        }
        return new result(200);

    }
}


