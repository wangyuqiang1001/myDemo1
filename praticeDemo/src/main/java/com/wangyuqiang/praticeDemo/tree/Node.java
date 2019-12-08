package com.wangyuqiang.praticeDemo.tree;

/**
 * 二叉搜索树节点类:
 */
public class Node {
    public Integer data;
    public Node leftNode;
    public Node rightNode;

    public void disPlay() {
        System.out.println(data);
    }

    public Node(Integer key) {
        this.data = key;
    }
}
