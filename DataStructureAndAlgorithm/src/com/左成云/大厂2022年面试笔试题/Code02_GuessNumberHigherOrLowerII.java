package com.左成云.大厂2022年面试笔试题;

public class Code02_GuessNumberHigherOrLowerII {
    public static int minGold(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return zuo(1, n, dp);
    }

    public static int zuo(int L, int R, int[][] dp) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        int res = 0;
        if (L == R) {
            res = 0;
        } else if (L == R - 1) {
            res = L;
        } else {

            int endLeft = L + zuo(L + 1, R, dp);
            int endRight = R + zuo(L, R - 1, dp);
            int min = Math.min(endLeft, endRight);

            for (int i = L + 1; i < R; i++) {
                int left = zuo(L, i - 1, dp);
                int right = zuo(i + 1, R, dp);
                int cur = i + Math.max(left, right);
                res = Math.min(cur, min);
            }
        }
        dp[L][R] = res;
        return dp[1][R];
    }
}
