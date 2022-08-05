package com.interview.chapter3二叉树问题.在二叉树中找到累加和为指定值的最长路径长度;

import java.util.HashMap;

public class GetMaxLength {
    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(3);
        head.left.left = new Node(1);
        head.left.right = new Node(0);
        head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.right = new Node(-9);
        head.right.left = new Node(2);
        head.right.left = new Node(1);
        System.out.println("result1: ");
        System.out.println(getMaxLength(head, 6));
        System.out.println("result2: ");
        System.out.println(getMaxLength(head, -9));
    }
    public static int getMaxLength(Node head, int sum) {
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        sumMap.put(0, 0); // 重要
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    public static int preOrder(Node head, int sum, int preSum, int level,
                        int maxLen, HashMap<Integer, Integer> sumMap) {
        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey((curSum - sum))) {
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
