package com.interview.chapter2.向有序的环形单链表中插入新节点;

public class InsertNum {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.next = node2;
        node2.next = node3;
        node3.next = head;
        print(head);
        head = insertNum(head, 2);
        head = insertNum(head, 5);
        head = insertNum(head, 0);
        print(head);

    }
    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }

    public static void print(Node head) {
        Node cur = head;
        while (true) {
            System.out.print(cur.value + " ");
            if(cur.next == head) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }
}
