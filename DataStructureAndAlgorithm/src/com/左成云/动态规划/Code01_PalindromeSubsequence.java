package com.左成云.动态规划;

public class test {
    public static void main(String[] args) {
        String str = "a12b3c43def2ghi1kpm";
        System.out.println(way(str));
//        System.out.println(way2(str));
    }

    public static int way(String str) {
        char[] str1 = str.toCharArray();
        char[] str2 = new char[str1.length];
        for (int i = str1.length - 1, j = 0; i >= 0; i--) {
            str2[j++] = str1[i];
        }
        return process1(str1, str2, str1.length - 1, str2.length - 1);
    }

    public static int process1(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return 0;
            }
        } else if (i == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i, j - 1);
            }
        } else if (j == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i - 1, j);
            }
        } else {
            int p1 = process1(str1, str2, i, j - 1);
            int p2 = process1(str1, str2, i - 1, j);
            int p3 = str1[i] == str2[j] ? 1 + process1(str1, str2, i - 1, j - 1) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    public static int way2(String str) {
        char[] str1 = str.toCharArray();
        char[] str2 = new char[str1.length];
        for (int i = str1.length - 1, j = 0; i >= 0; i--) {
            str2[j++] = str1[i];
        }
        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for (int j = 1; j < N; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }

        for (int i = 1; i < M; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }

        return dp[N - 1][M - 1];
    }
}
