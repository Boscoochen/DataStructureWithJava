package com.atguigu.stack.homework01;

import java.util.Scanner;

/**
 * 使用链表来模拟栈
 */
@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(4);
        boolean loop = true;
        while (loop) {
            System.out.println("请选择选项");
            System.out.println("1. add");
            System.out.println("2. pop");
            System.out.println("3. list");
            System.out.println("4. exit");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入值：");
                    int value = scanner.nextInt();
                    linkedListStack.add(value);
                    break;
                case "pop":
                    try {
                        int popValue = linkedListStack.pop();
                        System.out.println("pop的值为： " + popValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "list":
                    linkedListStack.list();
                    break;
                case "exit":
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

@SuppressWarnings({"all"})
class LinkedListStack {
    //先创建链头Head，初始化为0
    private static Node head = new Node(0);
    private Node next = null;
    //要创建栈node的数量
    private int num;
    //定义一个int变量来统计如栈的数量
    private int count = 0;

    public LinkedListStack(int num) {
        this.num = num;
    }

    public void add(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        Node curr = head;
        //创建新的节点
        Node newNode = new Node(value);
        //头插法
        newNode.next = head.next;
        head.next = newNode;
        //每插一个节点加一
        ++count;
    }

    //删除头节点
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        count--;
        int value = head.next.data;
        head.next = head.next.next;
        return value;
    }

    public void list() {
        if(head.next == null) {
            System.out.println("栈为空");
            return;
        }
        Node curr = head.next;
        int i = 0;
        while (true) {
            if (curr == null) {
                break;
            }
            System.out.println(++i + ". " + curr);
            curr = curr.next;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public boolean isFull() {
        return count == num;
    }
}




class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}




