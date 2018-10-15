package com.example.demo4.controller;

import com.example.demo4.entity.User;
import com.example.demo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangyi on 2017/4/10.
 * 上传文件控制器
 */
@RestController
public class UploadController {
    /**
     * 文件存储路径
     */
    private final String avatarPath="F:\\UploadFile\\avatar\\";

    @Autowired
    UserRepository userRepository;

    @RequestMapping("uploadFile")
    public String  uploadFile(@RequestParam("file")MultipartFile file,String savePath) {
        String result;
        File parentFile=new File(savePath);
        if (!parentFile.exists()) {
            //如果文件存储路径，则创建
            parentFile.mkdirs();
        }
        //MultipartFile会对上传的文件做一些封装，所以要获得源文件名要用file.getOriginalFilename()
        File myFile=new File(parentFile,file.getOriginalFilename());
        try {
            file.transferTo(myFile);
            result="success";
        } catch (IOException e) {
            e.printStackTrace();
            result="fail";
        }
        return result;
    }

    @RequestMapping("uploadAvatar")
    public String  uploadAvatar(@RequestParam("file")MultipartFile file,int uid) {
        String result;
        User user = userRepository.getUserById(uid);
        if (user == null) {
            return "用户不存在";
        }
        try {
            uploadFile(file,avatarPath);
            user.setAvatar(avatarPath+file.getName());
            userRepository.save(user);
            result="success";
        } catch (Exception e) {
            e.printStackTrace();
            result="fail";
        }
        return result;
    }
}
