package com.interview.chapter4递归和动态规划.矩阵的最小路径和;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] m = {
                {1,2,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

//        System.out.println(way1(0, 0, m));
//        System.out.println(way2(m,0, 0));
        System.out.println(way3(m));
    }

    public static int way2(int[][] m, int i, int j) {
        if (i ==m.length - 1 && j == m[0].length - 1) {
            return m[i][j];
        }

        if (i == m.length - 1) {
            return m[i][j] + way2(m, i, j + 1);
        } else if (j == m[0].length - 1) {
            return m[i][j] + way2(m, i + 1, j);
        } else {
            int p1 = m[i][j] + way2(m, i, j + 1);
            int p2 = m[i][j] + way2(m, i + 1, j);
            return Math.min(p1, p2);
        }
    }

    public static int way3(int[][] m) {
        int N = m.length;
        int M = m[0].length;
        int[][] dp = new int[N][M];
        dp[N - 1][M - 1] = m[N - 1][M - 1];

        for (int j = M - 2; j >= 0; j--) {
            dp[N - 1][j] = m[N - 1][j] + dp[N - 1][j + 1];
        }
        for (int i = N - 2; i >= 0; i--) {
            dp[i][M-1] = m[i][M - 1] + dp[i + 1][M - 1];
        }
        for (int i = N-2; i >= 0; i--) {
            for (int j = M-2; j >= 0; j--) {
                    int p1 = m[i][j] + dp[i][j + 1];
                    int p2 = m[i][j] + dp[i + 1][j];
                    dp[i][j] = Math.min(p1, p2);
            }
        }

        return dp[0][0];
    }







    public static int way1(int row, int col, int[][] m) {
        return process1(row, col, m);
    }

    public static int process1(int row, int col, int[][] m) {
        //base case
        if (row == m.length - 1 && col == m[0].length - 1) {
            return m[row][col];
        }

        if (row == m.length - 1) {
            return m[row][col] + process1(row, col + 1, m);
        }

        if (col == m[0].length - 1) {
            return m[row][col] + process1(row + 1, col, m);
        }

        int down = m[row][col] + process1(row + 1, col, m);
        int right = m[row][col] + process1(row, col + 1, m);
        return Math.min(down, right);
//        return m[row][col] + Math.min(process1(row+ 1, col, m), process1(row, col+1, m));
    }

    /**
     * {1,2,5,9},
     * {8,1,3,4},
     * {5,0,6,1},
     * {8,8,4,0}
     *
     */

}
