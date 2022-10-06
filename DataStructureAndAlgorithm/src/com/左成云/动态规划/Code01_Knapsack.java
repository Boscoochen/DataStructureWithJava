package com.左成云.动态规划;

public class Code01_Knapsack {
    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    public static int process(int[] w, int[] v, int index, int bag) {
        if (bag < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }

        int p1 = process(w, v, index + 1, bag);
        int next = process(w, v, index + 1, bag - w[index]);
        int p2 = 0;
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;

        System.out.println(maxValue(weights, values, bag));
    }
}
