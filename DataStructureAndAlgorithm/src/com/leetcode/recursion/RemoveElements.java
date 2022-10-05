package com.leetcode.recursion;

public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode next = removeElements(head.next, val);

        if(head.val == val) {
            return next;
        }

        head.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);

        ListNode res = removeElements(listNode, 6);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
