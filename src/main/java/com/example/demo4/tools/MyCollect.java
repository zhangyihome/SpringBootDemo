package com.example.demo4.tools;

import java.io.Serializable;

public class MyCollect<T extends Serializable> {
    private T t;
    public T get(){
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
