package com.example.demo4.controller;

import com.example.demo4.entity.MyResponse;
import com.example.demo4.entity.User;
import com.example.demo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/s")
    public String hello(){
        return "Hello User !";
    }

    @RequestMapping("t")
    public String tt(){
        return "Hello Test !";
    }

    @RequestMapping("add")
    public String add(User user){
        try {
            userRepository.save(user);
        }catch (Exception e){
            return "failed";
        }
        return "saved";
    }

    @RequestMapping("/getAllUser")
    public MyResponse getAllUser(User user){
        MyResponse myResponse=new MyResponse();
        try {
            myResponse.data=userRepository.findAll();
            myResponse.code=0;
            myResponse.des="success";
        }catch (Exception e){
            myResponse.code=1;
            myResponse.des="error";
        }
        return myResponse;
    }

    @RequestMapping("getUserByName")
    public MyResponse getUserByName(String name){
        MyResponse myResponse=MyResponse.getInstance();
        try {
            myResponse.setData(userRepository.getUserByName(name));
            User user = userRepository.getUserByName(name);

        }catch (Exception e){
            myResponse.failed();
        }
        return myResponse;
    }

    @RequestMapping("/getUserEmail")
    public MyResponse getUserEmail(String email){
        MyResponse myResponse=MyResponse.getInstance();
        try {
            myResponse.setData(userRepository.getUserEmail(email));
        }catch (Exception e){
            myResponse.failed();
        }
        return myResponse;
    }

}
