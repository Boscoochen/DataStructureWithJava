package com.左成云.动态规划;

public class Code01_RobotWalk {
    public static int ways(int N, int start, int aim, int K) {
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

    public static int way2(int N, int start, int aim, int K) {
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }

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
    public static void main(String[] args) {
        System.out.println(way2(4, 2,4,4));
    }
}
