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
        System.out.println(Fibonacci(5));
    }

    public static int Fibonacci(int n)
    {
        if(n == 1 || n == 2)
        {
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }


}
