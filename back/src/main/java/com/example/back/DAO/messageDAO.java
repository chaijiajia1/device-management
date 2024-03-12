package com.example.back.DAO;

import com.example.back.message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface messageDAO extends JpaRepository<message,Integer> {
    @Query("select d from message d where d.device_id=:device_id")
    List<message> getMessageByDevice_id(@Param("device_id") String device_id);
    @Query("select count(id) from message")
    int getNum();
    @Query("select d from message d ")
    List<message> getMessage();
}