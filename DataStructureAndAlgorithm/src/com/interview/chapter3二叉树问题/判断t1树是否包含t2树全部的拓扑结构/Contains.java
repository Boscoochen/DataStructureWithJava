package com.interview.chapter3二叉树问题.判断t1树是否包含t2树全部的拓扑结构;

public class Contains {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.left.right.left = new Node(10);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Node head2 = new Node(2);
        head2.left = new Node(4);
        head2.left.left = new Node(8);
        head.right = new Node(5);

        System.out.println(contains(head, head2));
    }
    public static boolean contains(Node t1, Node t2) {
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    public static boolean check(Node h, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (h == null || h.value != t2.value) {
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }
}
