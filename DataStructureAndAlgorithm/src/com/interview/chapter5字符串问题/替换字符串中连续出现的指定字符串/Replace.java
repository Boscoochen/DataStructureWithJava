package com.interview.chapter5字符串问题.替换字符串中连续出现的指定字符串;

public class Replace {
    public static void main(String[] args) {
        String str1 = "123abc";
        String from1 = "abc";
        String to1 = "4567";
        System.out.println("result1=" + replace(str1, from1, to1));

        String str2 = "123";
        String from2 = "abc";
        String to2 = "456";
        System.out.println("result2=" + replace(str2, from2, to2));

        String str3 = "123abcabc";
        String from3 = "abc";
        String to3 = "X";
        System.out.println("result3=" + replace(str3, from3, to3));

    }
    public static String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return str;
        }
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == chaf[match++]) {
                if (match == chaf.length) {
                    clear(chas, i, chaf.length);
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != 0) {
                cur = cur + String.valueOf(chas[i]);
            }
            if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if (!cur.equals("")) {
            res = res + cur;
        }
        return res;
    }

    public static void clear (char[] chas, int end, int len) {
        while (len-- != 0) {
            chas[end--] = 0;
        }
    }
}
