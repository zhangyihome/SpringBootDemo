package com.example.demo4.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
    private static final long serialVersionUID = -6309732882044872298L;
    
    private Integer id;
    private String username;
    private String operation;
    private String ip;
    private Date cTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}