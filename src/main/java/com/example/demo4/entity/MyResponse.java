package com.example.demo4.entity;

import com.example.demo4.tools.Constants;

public class MyResponse {
    public int code;
    public String des;
    public Object data;

    public static MyResponse getInstance(){
        MyResponse myResponse= new MyResponse();
        myResponse.des=System.currentTimeMillis()+"";
        return myResponse;
    }

    public void setData(Object data) {
        this.data = data;
        code= Constants.SSUCCESS;
    }

    public void failed() {
        code= Constants.ERROR;
    }
}
