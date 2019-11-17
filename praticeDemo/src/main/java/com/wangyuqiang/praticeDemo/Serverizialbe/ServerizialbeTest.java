package com.wangyuqiang.praticeDemo.Serverizialbe;

import java.io.*;

public class ServerizialbeTest {

    //博客
    //https://blog.csdn.net/qq_18298439/article/details/80607057
    //貌似序列化的实际意义是可以将对象转化为流的形式，方便存储以及在网络中传输


    public static void main(String[] args) throws Exception {
//        serializeUser();
        User user = unSerializeUser();
        System.out.println(user.toString()); //静态变量读出来的是内存中的数据:

    }


    public static void serializeUser() {
        User user = new User();
        user.setName("汪裕强");
        user.setCar("车");
        user.setColor("蓝色");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("d:/test/a.txt")));
            out.writeObject(user);
            System.out.println("序列化成功");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化：
     */
    public static User unSerializeUser() throws ClassNotFoundException, IOException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("d:/test/a.txt")));
        User u = (User) input.readObject();
        System.out.println("对象反序列化成功");
        return u;

    }
}
