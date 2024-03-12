
package com.example.back.service;

import com.example.back.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.back.DAO.messageDAO;
import java.util.List;

@Service
public class MessageServer {
    @Autowired
    messageDAO message_dao;
    public List<message> getByDevice_id(String ID){ return message_dao.getMessageByDevice_id(ID);}
    public int getNum(){return message_dao.getNum();}
    public List<message> getMessage(){return message_dao.getMessage();}
}
