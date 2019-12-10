package com.wangyuqiang.praticeDemo.tree;

/**
 * 根据二叉搜索树的相关特性来进行相关操作:
 * 把握原则，左边小于根，根小于右边:
 */
public class NodeImp implements Tree {

    private Node root;

    public void initNode() {

    }

    /**
     * 通过二叉搜索数来查找数据
     *
     * @param key
     * @return
     */
    @Override
    public Node findNode(Integer key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                current = current.leftNode;
            } else if (current.data < key) {
                current = current.rightNode;
            } else {
                break;
            }
        }
        return current;
    }

    @Override
    public boolean addMode(Integer key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return true;
        } else { //查找插入位置。(不断的循环。理论上这个树如果是按照搜索二叉树的规则定义的话，那么最多在第n层被查找到) log 2N复杂度。2是底数
            Node currentNode = root;
            Node parentNode = currentNode;
            while (currentNode != null) {
                if (currentNode.data > key) {
                    currentNode = currentNode.leftNode;
                    if (currentNode == null) {
                        parentNode.leftNode = node;
                        return true;
                    }

                } else if (currentNode.data < key) {
                    currentNode = currentNode.rightNode;
                    if (currentNode == null) {
                        parentNode.rightNode = node;
                        return true;
                    }
                }
            }


        }
        return false;
    }


    //删除操作:


    @Override
    public boolean removeNode(Integer key) {
        return false;
    }
}
