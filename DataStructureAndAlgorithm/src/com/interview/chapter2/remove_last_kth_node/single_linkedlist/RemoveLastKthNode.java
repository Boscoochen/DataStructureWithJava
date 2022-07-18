package com.interview.chapter2.remove_last_kth_node.single_linkedlist;

public class RemoveLastKthNode {
    public static Node head;
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head = node1;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print();
        head = removeLastKthNode(head, 5);
        System.out.println(head.hashCode());
        print();
    }
    public static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static Node removeLastKthNode(Node head, int lastKth) {
        System.out.println(head.hashCode());

        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
