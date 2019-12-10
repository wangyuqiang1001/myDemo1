package com.wangyuqiang.praticeDemo.proxy;

public class JavaDeveloper implements Developer {


    private String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void debug() {
        System.out.println("java developer can debug");
    }

    @Override
    public void code() {
        System.out.println("java developer can code");
    }
}
