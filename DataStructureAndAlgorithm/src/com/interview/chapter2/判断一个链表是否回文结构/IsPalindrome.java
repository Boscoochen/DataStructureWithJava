package com.interview.chapter2.判断一个链表是否回文结构;

import java.util.Stack;

public class IsPalindrome {
    public static Node head;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print();
        boolean result = isPalindrome3(head);
        System.out.println(result == true ? "is palindrome!" : "not palindrome");
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { //查找中间节点
            n1 = n1.next; //n1 -> 中部
            n2 = n2.next.next; //n2 -> 尾部
        }
        n2 = n1.next; //n2 -> 右部分第一个节点
        n1.next = null; //mid.next -> null
        Node n3 = null;
        while (n2 != null) { //右半区翻转
            n3 = n2.next; //n3 -> 保存下一个节点
            n2.next = n1; //下一个翻转节点
            n1 = n2; //n1 移动
            n2 = n3;// n2 移动
        }
        n3 = n1; //n3 -> 保存最后一个节点
        n2 = head; //n2 -> 左边第一个节点
        boolean res = true;
        while (n1 != null && n2 != null) { //检查回文
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; //从左到中部
            n2 = n2.next; //从右到中部
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { //恢复列表
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
