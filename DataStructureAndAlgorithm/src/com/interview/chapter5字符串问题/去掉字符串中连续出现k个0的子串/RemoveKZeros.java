package com.interview.chapter5字符串问题.去掉字符串中连续出现k个0的子串;

public class RemoveKZeros {
    public static void main(String[] args) {
        String str = "A00B";
        String str2 = "A0000B000";
        int k = 3;
        String result = removeKZeros(str2, k);
        System.out.println("res=" + result);
    }

    public static String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        char[] chas = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        chas[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0) {
                chas[start++] = 0;
            }
        }
        return String.valueOf(chas);
    }
}
