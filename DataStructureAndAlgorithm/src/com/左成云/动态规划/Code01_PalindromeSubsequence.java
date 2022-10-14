package com.左成云.动态规划;

public class Code01_PalindromeSubsequence {
    public static void main(String[] args) {
        String str = "a12b3c43def2ghi1kpm";
//        System.out.println(way(str));
//        System.out.println(way2(str));
//        System.out.println(lpsl(str));
        System.out.println(way3(str));
    }

    public static int lpsl(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        return f(s.toCharArray(), 0, N - 1);
    }

    public static int f(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return str[L] == str[R] ? 2 : 1;
        }

        //x L x R
        int p1 = f(str, L + 1, R - 1);
        //L xR
        int p2 = f(str, L, R - 1);
        int p3 = f(str, L + 1, R);
        int p4 = str[L] == str[R] ? 2 + f(str, L + 1, R - 1) : 0;
        return Math.max(Math.max(p1, Math.max(p2, p3)), p4);
    }

    public static int way3(String str) {
        char[] s1 = str.toCharArray();
        int N = s1.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0 ; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i == j - 1) {
                    dp[i][j] = s1[i] == s1[j] ? 2 : 1;
                }
            }
        }

//        dp[N - 1][N - 1] = 1;
//        for (int i = 0; i < N -1; i++) {
//            dp[i][i] = 1;
//            dp[i][i + 1] = s1[i] == s1[i + 1] ? 2 : 0;
//        }
        int n = 2;
        for (int j = 2; j < N ; j++) {
            for (int i = 0, k = 0; i < N - n; i++) {
                dp[i][j + k] = Math.max(dp[i][j - 1 + k], dp[i + 1][j + k]);
                if (s1[i] == s1[j + k]) {
                    dp[i][j + k] = Math.max(dp[i][j + k], 2 + dp[i + 1][j - 1 + k]);
                }
//                int p1 = dp[i + 1][j - 1 + k];
//                int p2 = dp[i][j - 1 + k];
//                int p3 = dp[i + 1][j + k];
//                int p4 = s1[i] == s1[j + k] ? (2 + dp[i + 1][j - 1 + k]) : 0;
//                dp[i][j + k] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
                k++;
            }
            n++;
        }

//        for (int i = N - 3; i >= 0; i--) {
//            for (int j = i + 2; j < N; j++) {
//                int p1 = dp[i + 1][j - 1];
//                int p2 = dp[i][j - 1];
//                int p3 = dp[i + 1][j];
//                int p4 = s1[i] == s1[j] ? (2 + dp[i + 1][j - 1]) : 0;
//                dp[i][j] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
//            }
//        }

        return dp[0][N - 1];
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
