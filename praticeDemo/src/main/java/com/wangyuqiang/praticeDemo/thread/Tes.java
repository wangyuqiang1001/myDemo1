package com.wangyuqiang.praticeDemo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tes {

//    private static ConcurrentHashMap<String, Integer> a = new ConcurrentHashMap<>();


    private static volatile Map a = new HashMap<String, Object>();


    //非线程安全map,无法保证线程安全: 即便加上volatile也无法保证。只能保证在线程之间的可见性，但是无法保证原子性:
    //即同一时间任然可能会有两个线程修改该静态变量：如果连volatile都不加，那么一个线程修改值后，并不能立即反应
    //刷新到主存中，更没安全性，所有单例多线程下静态变量的可见性并不是立即同步的;
    //只有使用线程安全容器，且不存在连续操作才能保证:
    //ConcurrentHashMap 在连续操作时也会有线程安全问题:
    // (比如获取当前数据自加1就会存在线程安全问题)考虑使用锁或者原子类解决:


    public void toKey(String key) {
        a.put(key, Integer.valueOf(key));

    }

    public Map getKey() {
        return a;
    }


    //考虑锁解决，使用同步代码块
    // 测试: (synginzed作用于类的两个不同方法可以实现么)？
    //实践结果:作用于当前对象：可以实现:不会同时执行:


    public synchronized void testA() {
        System.out.println("testA----->start");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testA--->end");
    }


    public synchronized void testB() {
        System.out.println("testB----->start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("testB----->end");
    }


}
