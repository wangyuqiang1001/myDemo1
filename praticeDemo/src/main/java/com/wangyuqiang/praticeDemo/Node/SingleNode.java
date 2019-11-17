package com.wangyuqiang.praticeDemo.Node;


import java.security.PrivateKey;
import java.util.LinkedList;

/**
 * 链表测试:2019/11/16
 * 目前我只知道链表有一个上节点还一个节点，prev,next,然后自身值:
 */
public class SingleNode {

    private Node head;//头节点:
    private int size;


    public SingleNode() {
        head = null;
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(
                Node<E> prev,
                E element,
                Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }


        public Node(E element) {
            this.item = element;
        }
    }

    //尝试实现以下几个功能:
    //添加,(添加到指定位置，查找，删除，删除指定位置) ()

    public <E> void addFirst(E elementValue) {
        Node<E> node = new Node<>(elementValue);
        if (head == null) {
            head = node;
            size++;
        } else { //非首元素，添加
            node.next = head;//将node添加到最前面；
            head = head;
            size++;
        }
    }

    //删除首个元素:
    public void deleteFirst() {
        if (head != null) {
            Object item = head.item;
            head = head.next;//将首节点的下一个节点 作为第一个节点:
            size--;
            System.out.println(item);
        }
    }

    //删除指定位置元素:
    //要求点在于节点删除以后,将prev指向next
    public boolean deleteItemSpe(Object deleteValue) {
        if (size == 0) {
            return false;
        }
        int count = 0;
        while (size > 0) {
            Node ifDelete = head;
            if (deleteValue.equals(ifDelete.item)) {


            } else {

            }
        }
        return false;
    }


    //查找指定元素:
    public Object findItem(Object itemValue) {
        if (head != null) { //循环遍历item.如果存在下一个的话，那个取出值进行相应的比较:
            Node current = head;
            while (current.next != null) {
                if (itemValue.equals(current.item)) {
                    return head.item;
                } else {
                    current = current.next;//如果不是的话那么指向下一个节点元素:
                }
            }
        }
        return null;
    }




    //双端链表,即在头部加入一个尾节点引用：这样如果在末尾插入时就不会有问题了：避免遍历，

    //双向链表，可以从两个方向扩展以及删除(从前到后，从后到前)

    //transient 关键字：代表的属性将不会被序列化:
}
