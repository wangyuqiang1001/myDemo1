package com.wangyuqiang.praticeDemo.thread;

public class TestThread {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());//获取当前线程优先级
        Thread.currentThread().setPriority(4);//设置当前线程优先级是4,,会影响子线程优先级么？
        System.out.println(new Thread().getPriority()); //子线程默认继承父线程的优先级。
    }
}
