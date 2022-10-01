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

        System.out.println(way1(0, 0, m));
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
