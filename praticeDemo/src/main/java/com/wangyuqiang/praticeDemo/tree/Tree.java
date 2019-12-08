package com.wangyuqiang.praticeDemo.tree;


/*
树的方法
 */
public interface Tree {
    //查找
    Node findNode(Integer key);

    //添加
    boolean addMode(Integer key);

    //删除
    boolean removeNode(Integer key);

}
