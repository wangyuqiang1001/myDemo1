package com.wangyuqiang.praticeDemo.Generic;

public class GenericTest2 {

    public static void main(String[] args) {
        Generic<String> stringGeneric = new Generic<>("123");
        stringGeneric.testIsSame("2312");//这里不能使用其他类型了。
        stringGeneric.getT2(1);//这里可以，因为方法声明了<K>,就不调用自身的
    }
}
