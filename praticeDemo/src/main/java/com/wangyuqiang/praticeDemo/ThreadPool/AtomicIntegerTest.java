package com.wangyuqiang.praticeDemo.ThreadPool;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作类测试：
 * 背景:  多线程下a++ 操作无法保证线程安全:
 */
public class AtomicIntegerTest {


    private static Integer a = 1;


    //volatile 只能保证该变量在多线程均能读取到最新数据，但是还是无法保证原子操作
//    private static volatile Integer a = 1;


//    private static AtomicInteger a = new AtomicInteger(0);


    private static ConcurrentHashMap<String, Integer> count = new ConcurrentHashMap();

    public static void main(String[] args) {
//        if (count.get("key") == null) {
//            count.put("key", 1);
//        }
        System.out.println("正式方法执行开始");

        for (int i = 0; i < 3000; i++) {
            new Thread() {
                @Override
                public void run() {
                    Integer a = count.get("key");
                    a++;
                    count.put("key", a);
                }
            }.start();
        }
        System.out.println(count.get("key"));
    }
}
