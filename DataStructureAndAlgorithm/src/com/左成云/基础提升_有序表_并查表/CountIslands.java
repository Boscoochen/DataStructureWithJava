package com.左成云.基础提升_有序表_并查表;

/**
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上，下，左，右 四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
 */
public class CountIslands {
    public static int countIslands(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, row, col);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i == N || j < 0 || j == M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i-1, j, N, M);
        infect(m, i+1, j, N, M);
        infect(m, i, j-1, N, M);
        infect(m, i, j+1, N, M);
    }

    public static void main(String[] args) {
        int[][] map = {{0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,1,0,0,0}};
        System.out.println(countIslands(map));
    }
}
