package com.Algorithm.kruskal;

public class KruskalCase {
    private int edgeNum;
    private char[] vertexes;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexes = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };

        KruskalCase kruskalCase = new KruskalCase(vertexes, matrix);
        kruskalCase.print();
    }

    public KruskalCase(char[] vertexes, int[][] matrix) {
        int vLen = vertexes.length;

        this.vertexes = new char[vLen];
        for (int i = 0; i < vertexes.length; i++) {
            this.vertexes[i] = vertexes[i];
        }

        this.matrix = new int[vLen][vLen];
        for (int i = 0; i < vLen; i++) {
            for (int j = 0; j < vLen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < vLen; i++) {
            for(int j = 0; j < vLen; j++) {
                if(this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void print() {
        System.out.println("临接矩阵为：");
        for (int i = 0; i < vertexes.length; i++) {
            for(int j = 0; j < vertexes.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
