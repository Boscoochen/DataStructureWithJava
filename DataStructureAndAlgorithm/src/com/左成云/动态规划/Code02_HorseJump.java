package com.左成云.动态规划;

/**
 * 当前来到的位置是（x，y）
 * 还剩下rest步需要跳
 * 跳完rest步，正好跳到a，b的方法数是多少？
 * //10*9
 */
public class Code02_HorseJump {
    public static int jump(int a, int b, int k) {
        return process(0, 0, k, a, b);
    }

    public static int process(int x, int y, int rest, int a, int b) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }

        if (rest == 0) {
            return x == a && y == b ? 1 : 0;
        }

        int ways = process(x + 2, y + 1, rest - 1, a, b);
        ways += process(x + 1, y + 2, rest - 1, a, b);
        ways += process(x - 1, y + 2, rest - 1, a, b);
        ways += process(x - 2, y + 1, rest - 1, a, b);
        ways += process(x - 2, y - 1, rest - 1, a, b);
        ways += process(x - 1, y - 2, rest - 1, a, b);
        ways += process(x + 1, y - 2, rest - 1, a, b);
        ways += process(x + 2, y - 1, rest - 1, a, b);
        return ways;
    }

    public static int jump2(int a, int b, int k) {
        int[][][] dp = new int[10][9][k+1];

        dp[a][b][0] = 1;
        for (int n = 1; n <= k; n++) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 8; j >= 0; j--) {
                    int ways = pick(dp,i + 2, j + 1, n - 1);
                    ways += pick(dp,i + 1, j + 2, n - 1);
                    ways += pick(dp,i - 1, j + 2, n - 1);
                    ways += pick(dp,i - 2, j + 1, n - 1);
                    ways += pick(dp,i - 2, j - 1, n - 1);
                    ways += pick(dp,i - 1, j - 2, n - 1);
                    ways += pick(dp,i + 1, j - 2, n - 1);
                    ways += pick(dp,i + 2, j - 1, n - 1);
                    dp[i][j][n] = ways;
                }
            }
        }
        return dp[0][0][k];
    }

    public static int pick(int[][][]dp, int x, int y, int rest) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][rest];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(jump(x, y, step));
        System.out.println(jump2(x, y, step));
    }
}
