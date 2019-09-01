package com.wangyuqiang.praticeDemo.Generic;

import java.util.List;

/**
 * 泛型类
 */
public class Generic<K> {

    private K key;

    public Generic(K k) {
        this.key = k;
    }

    public K getKey() {
        return key;
    }

    /**
     * 泛型类中的泛型方法,因为这是一个泛型方法,可以定义在泛型类中，泛型形参类型可以与泛型类相同，也可以不同。
     *
     * @param e
     * @param <E>
     * @return
     */
    public <E> E getE(E e) {
        return e;
    }

    /**
     * 这里虽然使用的是K,但是这个类型和改泛型类中定义的T类型是不一定一样，
     * 前面已经声明了<K> 了。可以理解为另外的一个类型了
     * 看前面是否带问号
     * @param t
     * @param <K>
     */
    public <K> void getT2(K t) {
        System.out.println(t);
    }


    /**
     * 这里的类型其实是使用类的泛型类型的。但是可以和类不一样么？
     * 个人感觉不行，但是可以么？
     * @param k
     */
    public  void  testIsSame(K k){
        System.out.println(k);
    }


    /**
     * 泛型方法可变参数。可以 传递可变参数泛型
     *
     * @param k
     * @param <K>
     */
    public <K> void getTArr(K... k) {
        for (K k1 : k
                ) {
            System.out.println(k1);

        }
    }

    /**
     * 那同理可得数组也可以的
     *
     * @param k1
     * @param <K>
     */
    public <K> void getArr2(List<K> k1) {

    }


    /**
     * 静态方法无法访问泛型定义的形参类型，其实我觉得这种写法不对，本来就是形参了调用的也不是类上的类型
     * 只能把他声明成一个静态泛型方法
     * 无法访问类中的泛型类型，其实也好理解，静态与对象无关呀()
     * @param k1
     * @param <K>
     */
    public static <K> void getArr3(K k1){

    }


}
