package com.wangyuqiang.praticeDemo.Serverizialbe;

import java.io.Serializable;


/**
 * 序列化测试类:
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    //这个uuid的作用是一个序列化的id，如果不提供，那么会根据当前对象的属性就计算出这个id值.
    //因此addTip属性在不被赋予的时候如果根据计算的Id序列化和反序列化会出错:
    private static String AGE = "2691";
    private String name;
    private String color;
    transient private String car;

    private String addTip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    //public String getAddTip() {
    //    return addTip;
    //}
    //
    //public void setAddTip(String addTip) {
    //    this.addTip = addTip;
    //}

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
                //", addTip='" + addTip + '\'' +
                '}';
    }
}
