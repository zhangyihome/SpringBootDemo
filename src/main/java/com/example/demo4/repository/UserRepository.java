package com.example.demo4.repository;

import com.example.demo4.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    User getUserByName(String name);
    User getUserById(int uid);
    @Query("select s from User s where s.email=:email")
    List<User> getUserEmail(@Param("email") String email);

    //@Query(value = "select u from User u where u.email = :email and u.name=:name", nativeQuery = true)
    //List<User> getUserEmail(@Param("name")String name,@Param("email") String email);
}
