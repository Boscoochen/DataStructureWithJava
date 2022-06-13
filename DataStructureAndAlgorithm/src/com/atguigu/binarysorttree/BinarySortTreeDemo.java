package com.atguigu.binarysorttree;

import java.util.ArrayList;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;
    public void add(Node node) {
        if(root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空， 不能遍历");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node search(int value) {
        if(value == this.value) {
            return this;
        }else if(value < this.value) {
            if (this.left == null) {
                return null;
            }
            this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
        return null;
    }

    public Node searchParent(int value) {
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }else {
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}




