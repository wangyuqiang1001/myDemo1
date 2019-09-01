###  Java泛型介绍

#### 1:概念

```
泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。

泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。
博客链接:  https://www.cnblogs.com/coprince/p/8603492.html
```

#### 2:特点

Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。

#### 3: 泛型具体应用

##### 3.1： 泛型类

一个普通的泛型类

```java
public class Generic<K> {
    //或者<K,V>写法等
    private K key;  
    public Generic(K k) {  
        this.key = k;  
    }  
    public K getKey() {  
        return key;
    }
```

泛型类一定要有这个<K>标志，否则就不是泛型类

1:泛型的类型参数只能是类类型，不能是简单类型。

2:不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错

##### 3.2： 泛型接口

一个普通的泛型接口：

```java
public interface Generator<T> {
    public T next();
}
```

注意点:实现泛型接口的类 或者继承的接口，在定义 类 时必须也写<T>,代表这个T类型的传递声明，除非在相同操作时指定具体类型:

```java
class FruitGenerator<T> implements Generator<T>{
    @Override
    public T next() {
        return null;
    }
}
```

当传入具体类型时:

```java
public class FruitGenerator implements Generator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
    }
}
```

##### 3.3 泛型通配符 

​       在学习java的时候，我们知道由于 java的多态性，比如在一个方法的参数我们传递的是一股 Animal动物类。在实际调用方法时我们可以传递相应的子类型，比如pig dog等类型，那么在泛型中能存在类似做法么？

实际上是能的，但是不是以这种方式，应该是<?> 或者是<?  extends A> 或者是<?  super A>这种形式，这个通配符代表的意思就是任意类型，

 具体代码如下：

```java
/** 
* 泛型通配符之间必须精确匹配: 
*
*
@param generic */
public void  showKeyValueType(Generic<Number> generic){  
    System.out.println(generic);
}

 public static void main(String[] args) {
      GenericTest genericTest = new GenericTest();
        Generic<Integer> test = new Generic<>(1);
     //Generic<> test = new Generic<Integer>(1);
     //这种方式没报错是因为我写法有问题，无法检测到 ，实际上我这种写法一直应该是有问题的
     //泛型类型应该的引用处声明。
     //在编辑阶段编译器已经发现错误了,就是说泛型类型必须精确匹配
     //  (com.wangyuqiang.praticeDemo.Generic.Generic<java.lang.Number>)
//        in GenericTest cannot be applied to               
//        (com.wangyuqiang.praticeDemo.Generic.Generic<java.lang.Integer>)
  //报错信息如上，类型无法转化,
        genericTest.showKeyValueType(test);
 }
```

泛型通配符对应的上下边界

这代表的是自身和自身的子类或者父类型(注意自身是包括的)

```java
/** 
* 泛型上边界，只能往下走 
* @param generic 
*/
public void showGenericDown(Generic<? extends Number> generic) 
{    System.out.println("继承number类的值:" + generic.getKey().getClass());
}
/** 
*  泛型下边界，只能往上走 
* @param generic 
*/
public void showGenericUp(Generic<? super Integer> generic) {    System.out.println("Integere父类类型" + generic.getKey().getClass());
                                                            }
```

##### 3.4  泛型方法

泛型方法的用处最为多而且也复杂，必须存在有<T>这样声明的才是泛型方法，如下

```java
/** * 真正的泛型方法，必须<T>这个标志。 
* 如果generic存在上下边界的话，那么再改泛型方法<T> 同样要声明边界
* @param generic 
* @param <T> 
* @return
*/
public <T> T showT(Generic<T> generic) {
    System.out.println(generic);    
    return generic.getKey();
}

//这种写法是错的，只要在方法中声明T,那么其实对于程序而言他是不知道T是什么类型的，就必须和上文一个<T>才可以
// public T showT(Generic<T> generic) {
//    return generic.getKey();
// }

    /**
     * 在这里如果尖括号里面的是T，那么将无法识别
     * 其实从我个人理解来看如果这里传T,相当于方法的形参类型不确定
     * ? 相当于可以理解为是Object类，即为所有类的父类，代表的是一个确定的类型实参
     * 同样这也不是一个泛型方法，只是使用了泛型统配符
     * @param generic
     */
    public void showKeyValue(Generic<?> generic) {
        System.out.println(generic.getKey());
    }

 /**
     * 泛型类中的泛型方法,因为这是一个泛型方法,可以定义在泛型类中，泛型形参类型可以与泛型类相同，也可以不同。
     * 这里其实代表的是一个其他类型的泛型，和泛型类里面这个类型就没有关系了
     * @param e
     * @param <E>
     * @return
     */
    public <E> E getE(E e) {
        return e;
    }

```

易错点：

如下：

```java
/** 
* 这里虽然使用的是K,但是这个类型和改泛型类中定义的T类型是不一定一样，
* 前面已经声明了<K> 了。可以理解为另外的一个类型了 
* 看前面是否带问号 
* @param t 
* @param <K> 
*/
public <K> void getT2(K t) { 
    System.out.println(t);}
/** 
* 这里的类型其实是使用类的泛型类型的。但是可以和类不一样么？ 
* 个人感觉不行，但是可以么？ 
* 其实不可以
* @param k 
*/
public  void  testIsSame(K k){   
    System.out.println(k);}
```

如果方法声明了<K> 类型 ，尽管看起来和泛型类中的k一样，实际上这里理解的概念应该是不一样的，这里是可以相同，也可以不相同，表示的含义不一样了，但是如果是 testIsSame 直接传递K类型，实际上这里传递的就是类的泛型类型，必须和类声明的一样。

如main方法所示

```java
public static void main(String[] args) { 
    Generic<String> stringGeneric = new Generic<>("123");    stringGeneric.testIsSame("2312");
    //这里不能使用其他类型了。 
    stringGeneric.getT2(1);
    //这里可以，因为方法声明了<K>,就不调用自身的
}
```

方法参数还可以传递泛型类型可变参数

<?> 和<T>的区别是什么?

其实简单的理解 来说T 类型，对应了一个具体的类型，但是?号则不限定类型。

同时?可以结合<? extends A> 或者<? super A>等结合使用

最后，Java中是不存在泛型 数组的。这是为什么？

https://blog.csdn.net/qq_38379983/article/details/90146160

大概的意思就是会破坏类型安全机制，任意一个数组类型可以被强制转化为 Object[] 类型，如果此时我们往这个Object数组中放入相应类型的非实际类型数组，最后实际上是一个我们不希望的类型， 假设我们放入的是一个泛型类型，由于类型擦除，这种代码在编译阶段并不能发现，所以最后在实际的业务逻辑中可能会出现由于类型不匹配带来很多意外的问题。

