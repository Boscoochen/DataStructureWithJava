package com.leetcode.左成云leetcode100.class01;

import java.util.Arrays;

public class G_left_B_right {
    public static void main(String[] args) {
        String[] str = {"B","B","G","G","B","B","G","B","G"};
//        way(str);
//        System.out.println(Arrays.toString(str));
        System.out.println(way2(str));
    }

    private static void way(String[] arr) {
        int n = arr.length;
        int L = 0;
        int R = 0;

        while (L < n) {
            while (R < n && !arr[R].equals("G")) {
                R++;
            }
            swap(arr, L++, R);
            if(R == 8) {
                break;
            }
        }
    }

    private static int way2(String[] arr) {
        int n = arr.length;
        int L = 0;

        int step1 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].equals("G")) {
                step1 += i - L++;
            }
        }

        int step2 = 0;
        int L2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("B")) {
                step2 += i - L2++;
            }
        }

        return Math.min(step1, step2);
    }

    private static void swap(String[] arr, int L, int R) {
        String temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
