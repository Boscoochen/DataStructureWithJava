package com.interview.chapter2.将搜索二叉树转换成双向链表;

import java.util.LinkedList;
import java.util.Queue;

public class Convert {
    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(4);
        head.left.left = new Node(2);
        head.left.left.left = new Node(1);
        head.left.right = new Node(5);
        head.left.left.right = new Node(3);
        head.right = new Node(7);
        head.right.right = new Node(9);
        head.right.right.left = new Node(8);
        inOrderPrint(head);
        System.out.println();
        head = convert2(head);
        print(head);
    }
    public static Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<Node>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public static void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    public static Node convert2(Node head) {
        if (head == null) {
            return null;
        }
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    public static Node process(Node head) {
        if (head == null) {
            return null;
        }
        Node leftE = process(head.left); // 左边结束
        Node rightE = process(head.right); // 右边结束
        Node leftS = leftE != null ? leftE.right : null; // 左边开始
        Node rightS = rightE != null ? rightE.right : null; // 右边开始
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if(leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }

    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void inOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }
}
