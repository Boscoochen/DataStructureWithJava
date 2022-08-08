package com.interview.chapter3二叉树问题.判断t1树中是否有与t2树拓扑结构完全相同的子树;

import com.interview.chapter3二叉树问题.判断t1树是否包含t2树全部的拓扑结构.Node;

public class IsSubtree {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(8);
        head.left.right = new Node(5);
        head.left.right.left = new Node(9);
        head.right = new Node(3);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Node head2 = new Node(2);
        head2.left = new Node(4);
        head2.left.right = new Node(8);
        head2.right = new Node(5);
        head2.right.left = new Node(9);

        Node head3 = new Node(2);
        head3.left = new Node(4);
        head3.left.right = new Node(8);
        head3.right = new Node(5);
        System.out.println(isSubTree(head, head2));
        System.out.println(isSubTree(head, head3));
    }
    public static boolean isSubTree(Node t1, Node t2) {
        String t1Str = serialByPre(t1);
        String t2Str = serialByPre(t2);
        return getIndexOf(t1Str, t2Str) != -1;
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

    //KMP
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
