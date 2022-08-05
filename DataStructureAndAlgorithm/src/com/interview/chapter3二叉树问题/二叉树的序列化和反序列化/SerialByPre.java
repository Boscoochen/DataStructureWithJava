package com.interview.chapter3二叉树问题.二叉树的序列化和反序列化;

import java.util.LinkedList;
import java.util.Queue;

public class SerialByPre {
    public static void main(String[] args) {
        System.out.println("方法1");
        Node head = new Node(12);
        head.left = new Node(3);
        System.out.println("result: ");
        String serialString = serialByPre(head);
        System.out.println(serialString);

        Node head2 = reconByPreString(serialString);
        print(head2);
        System.out.println();


        System.out.println("方法2：");
        Node head3 = new Node(1);
        head3.left = new Node(2);
        head3.left.left = new Node(4);
        head3.right = new Node(3);
        head3.right.right = new Node(5);
        String serialString2 = serialByLevel(head3);
        System.out.println(serialString2);
        Node head4 = reconByLevelString(serialString2);
        print(head4);
    }
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length; i++){
            queue.offer(values[i]);
        }
        return reConPreOrder(queue);
    }

    public static Node reConPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reConPreOrder(queue);
        head.right = reConPreOrder(queue);
        return head;
    }

    public static void print(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        print(head.left);
        print(head.right);
    }

    //方法2
    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    public static Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
