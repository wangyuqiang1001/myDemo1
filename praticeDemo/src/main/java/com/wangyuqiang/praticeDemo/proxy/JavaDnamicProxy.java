package com.wangyuqiang.praticeDemo.proxy;

import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;


/**
 * 动态代理代码：
 * 原始博客地址:   https://www.jianshu.com/p/95970b089360
 * 在我理解来看貌似就是一个基于原本类功能的实现扩展:
 */
public class JavaDnamicProxy {

    public static void main(String[] args) {
        JavaDeveloper jack = new JavaDeveloper("jack");
        Developer jackProxy = (Developer) Proxy.newProxyInstance(jack.getClass().getClassLoader(),
                jack.getClass().getInterfaces(), (Object proxy, Method method, Object[] arg) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("java has special ability to code");
                        return method.invoke(jack, args);
                    }
                    if (method.getName().equals("debug")) {
                        System.out.println("jack do not need debug");
                        return null;
                    }
                    return null;
                });
        jackProxy.code();
        jackProxy.debug();
    }
}
