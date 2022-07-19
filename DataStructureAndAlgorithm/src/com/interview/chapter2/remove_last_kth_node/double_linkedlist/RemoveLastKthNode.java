package com.interview.chapter2.remove_last_kth_node.double_linkedlist;

public class RemoveLastKthNode {
    public static DoubleNode head;

    public static void main(String[] args) {
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        DoubleNode doubleNode4 = new DoubleNode(4);
        DoubleNode doubleNode5 = new DoubleNode(5);
        head = doubleNode1;
        doubleNode1.next = doubleNode2;
        doubleNode2.last = doubleNode1;
        doubleNode2.next = doubleNode3;
        doubleNode3.last = doubleNode2;
        doubleNode3.next = doubleNode4;
        doubleNode4.last = doubleNode3;
        doubleNode4.next = doubleNode5;
        doubleNode5.last = doubleNode4;

        print();

        head = removeLastKthNode(head, 3);
        print();
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if(head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;

            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }

    public static void print() {
        DoubleNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
