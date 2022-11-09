package com.左成云.认识复杂度和简单排序算法;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,2,3,3};
        System.out.println(findOddNumber(nums));
    }

    public static int findOddNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor = eor ^ nums[i];
        }
        return eor;
    }
}
