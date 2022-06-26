package com.Algorithm.kruskal;

import java.util.Arrays;

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
        kruskalCase.kruskal();
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
            for(int j = i + 1; j < vLen; j++) {
                if(this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] res = new EData[edgeNum];
        EData[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共" + edges.length);
        sortEdge(edges);
        for(int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);

            if(m != n) {
                ends[m] = n;
                res[index++] = edges[i];
            }
        }
        System.out.println("最小生成树为=");
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
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

    private void sortEdge(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = i + 1; j < vertexes.length; j++) {
                if(matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexes[i], vertexes[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] ends, int i) {
        while(ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

class EData {
    char start;
    char end;
    int weight;
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                "}";
    }
}
