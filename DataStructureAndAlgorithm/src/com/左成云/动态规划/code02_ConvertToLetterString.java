package com.左成云.动态规划;

public class code02_ConvertToLetterString {
    // str只含有数字字符0～9
    // 返回多少种转换方案
    public static void main(String[] args) {
        String str = "1111";
        int start = 0;
        System.out.println(way(str, start));
    }

    public static int way(String str, int start) {
        char[] strArr = str.toCharArray();
//        return process(strArr, start);
        return dynamicProgramming(strArr);
    }

    public static int process(char[] arr, int start) {
        if (start == arr.length) {
            return 1;
        }

        if (arr[start] == '0') {
            return 0;
        }

        int total = process(arr, start + 1);

        if (start + 1 < arr.length && (arr[start] - '0') * 10 + (arr[start + 1] - '0') <= 26) {
            total += process(arr, start + 2);
        }
        return total;
    }

    public static int dynamicProgramming(char[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = arr[i] == '0' ? 0 : dp[i + 1];
            if (i + 1 < n && (arr[i] - '0') * 10 + (arr[i + 1] - '0') <= 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
