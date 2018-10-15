package com.example.demo4.controller;

import com.example.demo4.WebConfig;
import com.example.demo4.annotation.MyLog;
import com.example.demo4.entity.User;
import com.example.demo4.tools.MyCollect;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @MyLog("方法111")
    @GetMapping("/login")
    public String login() {
        return "login1";
    }

    @MyLog("方法22222")
    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password,Boolean remeberMe) {
    	// 密码MD5加密
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,remeberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseBo.ok();
        } catch (UnknownAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseBo.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }
    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String index(Model model) {
    	// 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index1";
    }
}