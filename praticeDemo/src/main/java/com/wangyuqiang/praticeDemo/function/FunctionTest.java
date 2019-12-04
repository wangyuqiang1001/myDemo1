package com.wangyuqiang.praticeDemo.function;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * java 8 函数式编程学习
 * 坚持会让你越来越强大，别三天打鱼，两天晒网
 */
public class FunctionTest {

    /**
     * 函数式编程方式
     * <p>
     * 当接口中只有一个抽象方式时，可以直接使用这种方式书写
     * 代码块只有一行时可以去掉中括号,
     */
    public static void test1() {
        Consumer d = (o) -> System.out.println(o);
        //再次简写可以理解为直接调用输出入参
        Consumer e = System.out::println;
    }

    /**
     * demo
     * consume
     */
    public static void test2() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");
        //执行完F后再执行F2的Accept方法
//        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f).andThen(f2).accept("test1");
        //这里相当于一个链式调用,可以理解成
    }

    /**
     * function:
     */
    public static void testFunction() {
        //当作该接口唯一非默认方法实现:
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;
        //相当于f的g的输出当做f的入参:
        System.out.println(f.compose(g).apply(1)); //1*2+1

        //f的出餐当做g的入参
        System.out.println(f.andThen(g).apply(1));  //(1+1)*2

        //不作处理
        System.out.println(Function.identity().apply("a"));


    }

    //Predicate
    public static void predictFunction() {

    }


    //函数式编程接口的使用: Stream

    public static void testStream() {
        Stream.generate(() -> Math.random()).limit(10).forEach(o -> System.out.println(o));
    }


    /**
     * stream中大量运用到了function 包中某些方式，直接使表达写，简洁。
     */
    public static void  testFilter() {
        Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
//        s.filter(n -> n.contains("t") || n.contains("b")).forEach(System.out::println);
        //map方法，对整个stream中内容作处理:
       s.map(o -> o.contains("a")?  o.concat("包含a") : o.concat("不包含a") ).forEach(System.out::println);
       s.filter(o -> o.contains("af")).forEach( m -> System.out.println(m));
    }


    public static void main(String[] args) {
//         FunctionTest.test2();
        // FunctionTest.testFunction();
//        FunctionTest.testStream();
        FunctionTest.testFilter();
    }

}
