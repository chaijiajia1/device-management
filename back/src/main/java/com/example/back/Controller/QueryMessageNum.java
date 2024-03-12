package com.example.back.Controller;

import com.example.back.message;
import com.example.back.receiver.querymessage_;
import com.example.back.service.MessageServer;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Controller
public class QueryMessageNum {
    @Autowired
    MessageServer message_service;

    @CrossOrigin  //allows cross-origin requests from other domains
    @PostMapping(value = "api/queryMessageNum")
    //this method be invoked when a Http Post request is sent to the URL api/login
    @ResponseBody  //serialize the returned object to the response body
    public ArrayList<Integer> queryDevice() throws JSONException, ParseException {
        List<message> res=message_service.getMessage();
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date0=new java.util.Date();//得到当前日期
        int num1=0;
        int num2=0;
        int num3=0;
        int num4=0;
        for (message message : res) {
            JSONObject jsonObject = new JSONObject(message.getMessage());
            java.util.Date date1 = tempDate.parse(jsonObject.get("timestamp").toString());
            long diffInMillis = Math.abs(date0.getTime() - date1.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);//得到差值
            if(diff<=7){
                num1++;
            }
            else if(diff<=14) num2++;
            else if(diff<=21) num3++;
            else if(diff<=28) num4++;
        }



        ArrayList<Integer> ret=new ArrayList<>();
        ret.add(num4);
        ret.add(num3);
        ret.add(num2);
        ret.add(num1);
        return ret;
    }
}
