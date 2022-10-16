package com.interview.chapter4递归和动态规划.最长公共子序列问题;

public class LongestCommonSubsequence {
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        //返回 "12345" 或者 返回 "12C4B6
        System.out.println(way1(str1, str2));
    }

    public static int way1(String str1, String str2) {
        return process1(str1.toCharArray(), str2.toCharArray(), str1.length() - 1, str2.length() - 1);
    }
    public static int process1(char[] s1, char[] s2, int i, int j) {
        if (i == 0 && j == 0) {
            if (s1[i] == s2[j]) {
                return 1;
            } else {
                return 0;
            }
        } else if (i == 0) {
            if (s1[i] == s2[j]) {
                return 1;
            } else {
                return process1(s1, s2, i, j - 1);
            }
        } else if (j == 0) {
            if (s1[i] == s2[j]) {
                return 1;
            } else {
                return process1(s1, s2, i - 1, j);
            }
        } else {
            int p1 = process1(s1, s2, i, j - 1);
            int p2 = process1(s1, s2, i - 1, j);
            int p3 = s1[i] == s2[j] ? 1 + process1(s1, s2, i - 1, j - 1) : 0;
            return Math.max(p1,Math.max(p2, p3));
        }
    }
}
