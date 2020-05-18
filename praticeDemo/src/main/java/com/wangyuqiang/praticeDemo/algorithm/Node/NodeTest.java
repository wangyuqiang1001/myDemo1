package com.wangyuqiang.praticeDemo.algorithm.Node;

public class NodeTest {


    /**
     * 发转单向链表
     *
     * @param head
     */
    public static void reverseNode(Node head) {
        if (head == null || head.getNext() == null) { //如果为空，直接返回
            return;
        }
        Node currentNode = head;
        Node preNode = null;
        Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(preNode); //第一个的话那么是空的:
            preNode = currentNode; //因为相当于链表往后挪，所以当前的Node是preNode,在下一次循环的时候生效:
            currentNode = nextNode; //当前的往后挪，是下一次循环的currentNode;
        }
        //最后得到的prevNode就是反转之后的初始节点:
        while (preNode.getNext() != null) {
            System.out.println(preNode.getData());
            preNode = preNode.getNext();
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        node1.setNext(node2);
        reverseNode(node1);
    }
}
