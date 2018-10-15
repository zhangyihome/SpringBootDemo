package com.example.demo4.shiro;

import com.example.demo4.pojo.UserOnline;

import java.util.List;

public interface SessionService {
    List<UserOnline> list();
    boolean forceLogout(String sessionId);
}
