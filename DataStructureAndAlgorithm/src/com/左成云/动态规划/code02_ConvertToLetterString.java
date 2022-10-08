package com.左成云.动态规划;

public class code02_ConvertToLetterString {
    // str只含有数字字符0～9
    // 返回多少种转换方案
    public static void main(String[] args) {
        String str = "115";
        int start = 0;
        System.out.println(way(str, start));
    }

    public static int way(String str, int start) {
        char[] strArr = str.toCharArray();
        return process(strArr, start);
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
}
