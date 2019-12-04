package com.wangyuqiang.praticeDemo.thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Tek {


    public static void main(String[] args) {


        Tes tes = new Tes();


        //测试单例多线程的可见性:
//        for (int i = 0; i < 1000; i++) {
//            int z = i;
//            new Thread() {
//                @Override
//                public void run() {
//                    tes.toKey(String.valueOf(z));
//                    System.out.println("i------->" + z);
//                }
//            }.start();
//        }
//
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(tes.getKey().size());
//
//
        //测试锁:
        new Thread() {
            @Override
            public void run() {
                tes.testA();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                tes.testB();
            }
        }.start();

    }


    public static void testHashTable() {
        Hashtable<String, Object> table = new Hashtable<>();
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    }
}
