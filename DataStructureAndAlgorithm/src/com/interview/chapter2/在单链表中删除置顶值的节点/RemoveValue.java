package com.interview.chapter2.在单链表中删除置顶值的节点;

import java.util.Stack;

public class RemoveValue {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        print(head);
//        head = removeValue(head,3);
        head = removeValue2(head, 3);
        print(head);
    }

    public static Node removeValue(Node head, int num) {
        Stack<Node> stack = new Stack<Node>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public static Node removeValue2(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
