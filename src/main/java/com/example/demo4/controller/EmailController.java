package com.example.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("send")
    public String send(String email) {
        try {
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper simpleMailMessage = new MimeMessageHelper (mimeMessage,true);
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("一封邮件");//标题
            simpleMailMessage.setText("使用SpringBoot发送邮件");//内容
            FileSystemResource fileSystemResource=new FileSystemResource("C:\\Users\\Administrator\\Desktop\\sc.png");
            simpleMailMessage.addAttachment("图片.png",fileSystemResource);
            javaMailSender.send(mimeMessage);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
