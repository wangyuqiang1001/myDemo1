package com.wangyuqiang.praticeDemo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树代码实现:
 */
public class BinTree {
    public BinTree left;
    public BinTree right;

    //根节点:
    public BinTree root;

    //数据域:
    private Object data;

    //所有节点的集合:
    private List<BinTree> dataList;


    public BinTree(BinTree left, BinTree right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinTree(Object data) {
        this(null, null, data);
    }


    public BinTree() {

    }


    //初始化节点树
    public void createTree(Object[] objs) {
        dataList = new ArrayList<BinTree>();
        Arrays.stream(objs).forEach(obj -> {
            dataList.add(new BinTree(obj));
        });
        root = dataList.get(0);
        for (int i = 0; i < objs.length / 2; i++) {
            dataList.get(i).left = dataList.get(i * 2 + 1);
            //假如当前是偶数，那么比如10，最大的i是4 .那么取下标为10的，就是第11个元素，数组越界了:
            if (i * 2 + 2 < dataList.size()) {
                dataList.get(i).right = dataList.get(i * 2 + 2);
            }
        }
    }

    //前序遍历：根节点，左右
    //中序遍历: 左根右
    //后序遍历: 左右根

    /**
     * 前序:
     *
     * @param node
     */
    public void prevTree(BinTree node) {
        if (node != null) {
            System.out.println(node.data);
            prevTree(node.left);
            prevTree(node.right);
        }
    }


    /**
     * 中序:
     *
     * @param node
     */
    public void centerTree(BinTree node) {
        if (node != null) {
            prevTree(node.left);
            System.out.println(node.data);
            prevTree(node.right);
        }
    }


    /**
     * 后序:
     *
     * @param node
     */
    public void afterTree(BinTree node) {
        if (node != null) {
            prevTree(node.left);
            prevTree(node.right);
            System.out.println(node.data);
        }
    }


    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        binTree.createTree(a);
        binTree.prevTree(binTree.root);

    }


    //数组是一片连读的地址空间，因此查找效率高。但是插入删除的话，需要挪动很多数据‘
    //链表由于是引用指向，在内存空间中不是连续的，因此方便插入和删除，但是不利于查询。
    //但是树可以兼顾两者的优点：
    //二叉搜索树，他的子节点必须小于父节点的值，他的右节点的值必须大于父节点的值


}
