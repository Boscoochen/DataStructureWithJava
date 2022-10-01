package com.左成云.动态规划;

public class Code01_RobotWalk {
    public static int ways1(int N, int start, int aim, int K) {
        return process1(start, K, aim, N);
    }

    //机器人当前来到的位置是cur
    //机器人还有rest步需要去走
    //最终的目标是aim
    //有哪些位置？1～N
    //返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { //如果已经不需要走了，走完了
            return cur == aim ? 1 : 0;
        }
        //rest>0,还有步数要走
        if (cur == 1) { // 1->2
            return process1(2, rest - 1, aim, N);
        }

        if (cur == N) { // n-1 <- N
            return process1(N - 1, rest - 1, aim, N);
        }

        // 1 2 3 4 5 6 7
        //中间位置上
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

    public static int ways2(int N, int start, int aim, int K) {
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }

        // dp就是缓存表
        // dp[cur][rest] == -1 -> process2(cur, rest)之前没算过
        // dp[cur][rest] != -1 -> process2(cur, rest)之前算过， 返回值就是 dp[cur][rest]
        // N+1 * K+1
        return process2(start, K, aim, N, dp);
    }

    // cur 范围：1~N
    // rest 范围：0～k
    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }

        int ans = 0;

        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp)
                    + process2(cur + 1, rest - 1, aim, N, dp);
        }

        dp[cur][rest] = ans;
        return ans;
    }

    public static int ways3(int N, int start, int aim, int K) {
        int[][] dp = new int[N+1][K+1];
        dp[aim][0] = 1; // dp[...][0] = 0
        /**
         * 自己的版本
        for (int col = 1; col <= K; col++) {
            for (int row = 1; row <= N; row++) {
                if (row == 1) {
                    dp[row][col] = dp[2][col-1];
                } else if (row == N) {
                    dp[row][col] = dp[row-1][col-1];
                } else {
                    dp[row][col] = dp[row-1][col-1] + dp[row+1][col-1];
                }
            }
        }
         */

        for (int col = 1; col <= K; col++) {
            dp[1][col] = dp[2][col-1];
            for (int row = 2; row < N; row++) {
                dp[row][col] = dp[row-1][col-1] + dp[row+1][col-1];
            }
            dp[N][col] = dp[N-1][col-1];
        }

        /**
         * 打印缓存表
         */
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[start][K];
    }

    public static void main(String[] args) {
//        System.out.println(way2(5, 2,4,6));
//        System.out.println(ways2(6, 3, 6, 9));
        System.out.println(ways3(5, 2,4,6));
    }
}
