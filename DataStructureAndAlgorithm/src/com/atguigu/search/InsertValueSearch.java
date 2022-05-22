package com.atguigu.search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length-1, 78);
        System.out.println("index = " + index);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        System.out.println("查找次数");
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (findValue > midVal) {
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return insertValueSearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
