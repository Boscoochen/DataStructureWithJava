package com.interview.chapter4递归和动态规划.矩阵的最小路径和;

public class MinPathSum2 {
    public static void main(String[] args) {
        int[][] m = {
                {1, 3, 5, 9},
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

        int[][] dp2 = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp2[i][j] = -1;
            }
        }

//
//        System.out.println(way1(m, 0, 0, dp));
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("=====");
        System.out.println(way2(m, dp2));

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
        } else {
            res = map[i][j] + Math.min(process1(map, i + 1, j, dp), process1(map, i, j + 1, dp));
        }

        dp[i][j] = res;

        return res;
    }

    /**
     * public static int process1(int row, int col, int[][] m) {
     * //base case
     * if (row == m.length - 1 && col == m[0].length - 1) {
     * return m[row][col];
     * }
     * <p>
     * if (row == m.length - 1) {
     * return m[row][col] + process1(row, col + 1, m);
     * }
     * <p>
     * if (col == m[0].length - 1) {
     * return m[row][col] + process1(row + 1, col, m);
     * }
     * <p>
     * int down = m[row][col] + process1(row + 1, col, m);
     * int right = m[row][col] + process1(row, col + 1, m);
     * return Math.min(down, right);
     * //        return m[row][col] + Math.min(process1(row+ 1, col, m), process1(row, col+1, m));
     * }
     */

    public static int way2(int[][] map, int[][] dp) {
        int row = map.length - 1;
        int col = map[0].length - 1;
        dp[row][col] = map[row][col];

        for (int j = col; j >= 0; j--) {
            for (int i = row; i >= 0; i--) {
                if (i == 3 && j == 3) {
                    continue;
                }
                if (i <= 2 && j == 3) {
                    dp[i][j] = map[i][j] + dp[i + 1][j];
                } else if (i == 3 && j <= 2) {
                    dp[i][j] = map[i][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = map[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][0];
    }
}
