package com.左成云.大厂2022年面试笔试题;

/**
 * 我们正在完一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字。
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏。
 * 如果猜错了，那么我会告诉你，我选的数字比你的更大或者更小，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。
 * 如果你花光了钱，就会 输掉游戏。
 * 给你一个特定的数字 n， 返回能够确保你获胜的最小现金数，不管我选择哪个数字。
 */
public class Code02_GuessNumberHigherOrLowerII {
    public static void main(String[] args) {
        System.out.println(minGold(10));
        System.out.println(minGold2(10));
    }
    public static int minGold(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return zuo2(1, n, dp);
//        return zuo(1, n);
    }

    public static int zuo2(int L, int R, int[][] dp) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        int res = 0;
        if (L == R) {
            res = 0;
        } else if (L == R - 1) {
            res = L;
        } else {

            int endLeft = L + zuo2(L + 1, R, dp);
            int endRight = R + zuo2(L, R - 1, dp);
            res = Math.min(endLeft, endRight);

            for (int i = L + 1; i < R; i++) {
                int left = zuo2(L, i - 1, dp);
                int right = zuo2(i + 1, R, dp);
                int cur = i + Math.max(left, right);
                res = Math.min(cur, res);
            }
        }
        dp[L][R] = res;
        return res;
    }

    /**
     * 假设现在在L ~ R 的范围上，猜数字
     * 返回：确保获胜的最小现金数，不管答案是哪个数字
     * 注意：所谓的"确保获胜"，以及"不管答案是哪个数字"，意味着你每次永远面临猜错的最差情况！
     * @param L
     * @param R
     * @return
     */
    public static int zuo(int L, int R) {
        //说明L~R范围，只剩下一个数字了，那不用猜了，获胜了
        if (L == R) {
            return 0;
        }
        // 说明L~R范围，只剩下两个数字了
        // 比如：5 6
        // 假设永远会遇到最差情况，
        // 那么当然猜5，因为最差情况下，也只需要耗费5的代价，然后就知道了答案是6
        // 不能猜6，因为最差情况下，需要耗费6的代价，然后才知道答案是5
        // 所以当然选代价低的！请深刻理解：每次永远面临猜错的最差情况！
        if (L == R - 1) {
            return L;
        }

        // 如果说明L~R范围，不仅仅两个数字
        // 比如：5 6 7 8 9
        // 首先尝试5，如果最差情况出现，代价为：5 + 6～9范围上的尝试
        // 最后尝试9，如果最差情况出现，代价为：9 + 5～8范围上的尝试
        int min = Math.min(L + zuo(L + 1, R), R + zuo(L, R - 1));
        // 进而尝试6，如果最差情况出现，代价为：6 + Max { 5~5范围上的尝试，7～9范围上的尝试}
        // 这是因为猜了6，会告诉你，猜高了还是猜低了，所以左右两侧的待定范围，一定会只走一侧
        // 又因为永远会遇到最差情况，所以，一定会走最难受的那一侧，所以是Max { 5~5范围上的尝试，7～9范围上的尝试}
        // 进而尝试7，如果最差情况出现，代价为：7 + Max { 5~6范围上的尝试，8～9范围上的尝试}
        // 进而尝试8，如果最差情况出现，代价为：8 + Max { 5~7范围上的尝试，9～9范围上的尝试}
        // 所有尝试中，取代价最小值
        for (int i = L + 1; i < R; i++) {
            min = Math.min(min, i + Math.max(zuo(L, i - 1), zuo(i + 1, R)));
        }
        return min;
    }

    public static int minGold2(int n) {
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i < n; i++) {
            dp[i][i+1] = i;
        }

        for (int L = n - 2; L >= 1; L--) {
            for (int R = L + 2; R <= n; R++) {
                int min = Math.min(L + dp[L + 1][R], R + dp[L][R - 1]);
                for (int i = L + 1; i < R; i++) {
                    min = Math.min(min, i + Math.max(dp[L][i - 1], dp[i + 1][R]));
                }
                dp[L][R] = min;
            }
        }
        return dp[1][n];
    }
}
