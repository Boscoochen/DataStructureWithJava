package com.左成云.认识复杂度和简单排序算法;

public class Code02_InsertionSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 5, 2, 3, 1};
        insertionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
