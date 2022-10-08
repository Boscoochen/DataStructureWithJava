package com.leetcode.recursion;

public class ReorderList {
    private static ListNode temp;
    private static boolean isStop;

    public static void reorderList(ListNode head) {
        temp = head;
        isStop = false;
        reorder(head);
    }

    private static void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);

        if (!isStop) {
            ListNode next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }

        if (temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
        reorderList(listNode);
        System.out.println();
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
