package com.example.back.service;
import com.example.back.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.back.DAO.deviceDAO;
@Service
public class DeviceService {
    @Autowired
    deviceDAO device_dao;
    public Device getByID(String ID){ return device_dao.getDeviceByDevice_id(ID);}
    public void setName(String name,String device_id){device_dao.setDeviceName(name,device_id);}
    public void setType(String type,String device_id){device_dao.setDeviceType(type,device_id);}
    public void setUsername(String username,String device_id){device_dao.setDeviceUsername(username,device_id);}
    public void add(String device_id,String name,String type,String username){device_dao.save(new Device(device_id,name,type,username));}
    public int getNum(){return device_dao.getNum();}
    public int getActiveNum(){return device_dao.getActiveNum("yes");}
}
