package com.interview.chapter3二叉树问题.调整搜索二叉树中两个错误的节点;

import java.util.Stack;

public class GetTwoErrNodes {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.left = new Node(4);
        head.right = new Node(2);
        Node[] result = getTwoErrNodes(head);
        System.out.println(result[0]);
        System.out.println(result[1]);


    }
    public static Node[] getTwoErrNodes(Node head) {
        Node[] errs = new Node[2];
        if (head == null) {
            return errs;
        }
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }
}
