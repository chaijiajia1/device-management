package com.example.back.DAO;

import com.example.back.Device;
import com.example.back.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Repository
public interface deviceDAO extends JpaRepository<Device,Integer>{
    @Query("select d from Device d where d.device_id=:device_id")
    Device getDeviceByDevice_id(@Param("device_id") String device_id);
    @Modifying
    @Transactional
    @Query("update Device d set d.name=:name where d.device_id=:device_id")
    void setDeviceName(@Param("name")String name,String device_id);
    @Modifying
    @Transactional
    @Query("update Device d set d.type=:type where d.device_id=:device_id")
    void setDeviceType(@Param("type")String type,String device_id);
    @Modifying
    @Transactional
    @Query("update Device d set d.username=:username where d.device_id=:device_id")
    void setDeviceUsername(@Param("username")String username,String device_id);

    @Query("select count(device_id) from Device")
    int getNum();
    @Query("select count(d) from Device d where d.active=:active")
    int getActiveNum(@Param("active") String active);


}
