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

    public static int dynamicProgramming(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];

        for (int i = N-1; i >= 0; i--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[i + 1][rest];
                int p2 = 0;
                int next = rest - w[i] < 0 ? -1 : dp[i + 1][rest - w[i]];
                if (next != -1) {
                    p2 = v[i] + next;
                }
                dp[i][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;

//        System.out.println(maxValue(weights, values, bag));
        System.out.println(dynamicProgramming(weights, values, bag));
    }
}
