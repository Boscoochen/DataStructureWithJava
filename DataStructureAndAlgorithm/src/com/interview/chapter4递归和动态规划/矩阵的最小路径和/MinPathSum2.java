package com.interview.chapter4递归和动态规划.矩阵的最小路径和;

public class MinPathSum2 {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };

        int row = m.length;
//        System.out.println(row);
        int col = m[0].length;
//        System.out.println(col);

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(way1(m, 0, 0, dp));
    }

    public static int way1(int[][] map, int row, int col, int[][] dp) {
        return process1(map, row, col, dp);
    }

    public static int process1(int[][] map, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;

        if (i == map.length - 1 && j == map[0].length - 1) {
            res = map[i][j];
        } else if (i == map.length - 1) {
            res = map[i][j] + process1(map, i, j + 1, dp);
        } else if (j == map[0].length - 1) {
            res = map[i][j] + process1(map, i + 1, j, dp);
        }else {
            res = map[i][j] + Math.min(process1(map, i + 1, j, dp), process1(map, i, j + 1, dp));
        }

        dp[i][j] = res;

        return res;
    }


}
