package com.leetcode.左成云leetcode100.class01;

public class Code01_CordCoverMaxPoint {
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 6, 9, 10, 12, 17};
        int rope = 9;
        System.out.println(maxPoint(arr, rope));
    }

    private static int maxPoint(int[] arr, int rope) {
        return process(arr, rope);
    }

    private static int process(int[] arr, int rope) {
        int N = arr.length;
        int L = 0;
        int R = 0;
        int max = 0;
        while (L < N) {
            while (R < N && arr[R] - arr[L] <= rope) {
                R++;
            }
            return Math.max(max, (R - L++));
        }
        return max;
    }
}
