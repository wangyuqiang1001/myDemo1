package com.wangyuqiang.praticeDemo.reflex;

import org.junit.jupiter.api.Test;

public class TestReflex {

    public static void main(String[] args) {

        //   一: 反射机制获取Class对象的三种方式:

        //1:通过类名: (jvm对每一个类对应的.class是动态加载的，在这里用到了会把.class对应的Class对象加载到jvm中)
        Class userClass = User.class;
        System.out.println(userClass);
        //2: 通过实例化对象: 如user.getClass();
        //3: 通过类全名:(需要通过整个工程的全名路径获取);
        try {
            Class<?> userClass2 = Class.forName("com.wangyuqiang.praticeDemo.reflex.User");
            System.out.println(userClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        testNewInstance();


    }

    //  二: 利用newInstance 创建对象必须拥有无参构造方法:
    public static void testNewInstance() {

        try {
            Class<?> user = Class.forName("com.wangyuqiang.praticeDemo.reflex.User");
            Object obj = user.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
