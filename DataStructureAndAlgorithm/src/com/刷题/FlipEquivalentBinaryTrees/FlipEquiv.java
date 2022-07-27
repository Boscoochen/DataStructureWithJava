package com.刷题.FlipEquivalentBinaryTrees;

import java.util.ArrayList;

public class FlipEquiv {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.left.right.left = new Node(7);
        head1.left.right.right = new Node(8);
        head1.right = new Node(3);
        head1.right.left = new Node(6);

        Node head2 = new Node(1);
        head2.left = new Node(3);
        head2.left.right = new Node(6);
        head2.right = new Node(2);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.right.left = new Node(8);
        head2.right.right.right = new Node(7);

        if (flipEquiv(head1, head2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean flipEquiv(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;

        if((root1 == null || root2 == null)||(root1.val != root2.val))
            return false;

        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        flip = flip || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
        return flip;
    }

    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }

//    public static void inOrderFlip(Node head) {
//        if (head == null) {
//            return;
//        }
//        inOrderFlip(head.right);
//        System.out.print(head.val + " ");
//        inOrderFlip(head.left);
//    }

    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void posOrder(Node head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val + " ");
    }
}

