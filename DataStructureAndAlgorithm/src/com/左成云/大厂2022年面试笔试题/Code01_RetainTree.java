package com.左成云.大厂2022年面试笔试题;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵多叉树的头节点head，根据图理解题意
 * 返回处理后的树的头节点
 */
public class Code01_RetainTree {
    public static class Node {
        //值
        public int value;
        //是否保留
        public boolean retain;
        //下级节点
        public List<Node> nexts;

        public Node(int v, boolean r) {
            value = v;
            retain = r;
            nexts = new ArrayList<>();
        }
    }

    // 给定一棵树的头节点head
    // 请按照题意，保留节点，没有保留的节点删除
    // 树调整完之后，返回头节点
    public static Node retain(Node x) {
        if (x.nexts.isEmpty()) {
            return x.retain ? x : null;
        }
        // 下层有节点
        List<Node> newNexts = new ArrayList<>();
        for (Node next : x.nexts) {
            Node newNext = retain(next);
            if (newNext != null) {
                newNexts.add(newNext);
            }
        }

        if (!newNexts.isEmpty() || x.retain) {
            x.nexts = newNexts;
        }
        return null;
    }
}
