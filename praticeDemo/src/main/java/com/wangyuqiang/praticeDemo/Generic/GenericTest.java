package com.wangyuqiang.praticeDemo.Generic;

public class GenericTest {


    /**
     * 真正的泛型方法，必须<T>这个标志。
     * 如果generic存在上下边界的话，那么再改泛型方法<T> 同样要声明边界
     * @param generic
     * @param <T>
     * @return
     */
    public <T> T showT(Generic<T> generic) {
        System.out.println(generic);
        return generic.getKey();
    }


    /**
     * 在这里如果尖括号里面的是T，那么将无法识别
     * 其实从我个人理解来看如果这里传T,相当于方法的形参类型不确定
     * ? 相当于可以理解为是Object类，即为所有类的父类，代表的是一个确定的类型实参
     *
     * @param generic
     */
    public void showKeyValue(Generic<?> generic) {
        System.out.println(generic.getKey());
// 博客链接:  https://www.cnblogs.com/coprince/p/8603492.html
        //? 和 T 的区别就在于当我使用到泛型类。由于已经声明好，T是一个确定的类型，在编译阶段，但是?可以传递多个类型
    }

    /**
     * 泛型上边界，只能往下走
     * @param generic
     */
    public void showGenericDown(Generic<? extends Number> generic) {
        System.out.println("继承number类的值:" + generic.getKey().getClass());
    }


    /**
     *  泛型下边界，只能往上走
     * @param generic
     */
    public void showGenericUp(Generic<? super Integer> generic) {
        System.out.println("Integere父类类型" + generic.getKey().getClass());
    }


    /**
     * 泛型通配符之间必须精确匹配:
     *
     * @param generic
     */
    public void  showKeyValueType(Generic<Number> generic){
        System.out.println(generic);
    }


    //不存在泛型数组:

    public static void main(String[] args) {
        Generic<Integer> numberGeneric = new Generic<Integer>(1);
        numberGeneric.getT2("223");


        GenericTest genericTest = new GenericTest();
        Generic<Integer> test = new Generic<>(1);



        genericTest.showGenericDown(new Generic<Integer>(1));
        genericTest.showGenericDown(new Generic<Number>(2));



    }

}
