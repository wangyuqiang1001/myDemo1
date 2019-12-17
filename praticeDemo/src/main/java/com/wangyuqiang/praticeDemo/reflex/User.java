package com.wangyuqiang.praticeDemo.reflex;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * 用户类继承中国人类实现人的接口
 */
public class User extends ChinesePeople implements People {
    private String userName;
    private String password;

    public User(String userName, String password) {
        System.out.println("调用了有参数的构造方法");
        this.userName = userName;
        this.password = password;
    }

//    public User() {
//        System.out.println("调用了人类--->无参数的构造方法:");
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    @Override
    String buyHouse() {
        return null;
    }

    @Override
    public String eat() {
        return null;
    }

    @Override
    public String work() {
        return null;
    }
}
