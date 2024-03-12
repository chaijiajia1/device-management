package com.example.back.DAO;

import com.example.back.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.back.User;
import java.util.List;
@Repository  //标志当前类要交给spring容器管理，生成bean
public interface userDAO extends JpaRepository<User,Integer>{
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.password=:pass")
    User getUserByPassword(@Param("pass") String pass);

    @Query("select u from User u where u.email=:email")
    User getUserByEmail(@Param("email") String email);
     //这里的重点在于由于使用了JPA，不用写SQL语句，只要按照规定的名字就可以
}
