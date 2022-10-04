package com.leetcode.recursion;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode head = mergeTwoLists(listNode, listNode2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        return process(list1, list2, temp, res).next;
    }

    public static ListNode process(ListNode list1, ListNode list2, ListNode temp, ListNode res) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode newNode = new ListNode(list1.val);
                temp.next = newNode;
                process(list1.next, list2, temp.next, res);
            } else {
                ListNode newNode = new ListNode(list2.val);
                temp.next = newNode;
                process(list1, list2.next, temp.next, res);
            }
        }

        if (list1 == null && list2 != null) {
            temp.next = list2;
        } else if (list1 != null && list2 == null) {
            temp.next = list1;
        }

        return res;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
