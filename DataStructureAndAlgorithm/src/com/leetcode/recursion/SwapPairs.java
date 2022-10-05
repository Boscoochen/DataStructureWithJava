package com.leetcode.recursion;

import java.util.List;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        int count = 1;
        ListNode res = process(head, fast, count);
        return res;
    }

    public static ListNode process(ListNode head, ListNode fast, int count) {
        if (fast == null) {
            return null;
        }
        ListNode next = process(head.next, fast.next, ++count);
        //fast = 4
        //head = 3
        if (count % 2 == 0) {
            ListNode temp = fast;
            head.next = fast.next;
            temp.next = head;
            next = temp;
            return next;
        } else {
            next = fast;
        }

        head.next = next;
        return head;
    }

    public static ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode next = head.next;
        head.next = swapPairs2(head.next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode head = swapPairs2(listNode);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
