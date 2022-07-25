package com.interview.chapter2.在单链表和双链表中删除倒数第K个节点.double_linkedlist;

public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }
}
