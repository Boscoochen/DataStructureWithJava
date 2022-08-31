package com.interview.chapter3二叉树问题.判断一颗二叉树是否为搜索二叉树和完全二叉树;

public class Test {
    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(3);
        head.left.left = new Node(1);
        head.left.left.right = new Node(2);
        head.left.right = new Node(4);
        head.left.right.right = new Node(5);
        head.right = new Node(9);
        head.right.left = new Node(8);
        head.right.left.left = new Node(7);
        head.right.right = new Node(10);

        if (IsBST.isBST(head)) {
            System.out.println("是搜索二叉树");
        } else if (IsCBT.isCBT(head)) {
            System.out.println("是完全二叉树");
        }
    }
}
