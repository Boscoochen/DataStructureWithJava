package com.左成云.认识复杂度和简单排序算法;

public class Test {
    static int[] res = new int[2];

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 2, 3, 3};
        int[] nums2 = {1, 2, 1, 1, 2, 3, 3, 2};
        System.out.println(findOddNumber(nums));
//        find2OddNumber(nums2);
        int[] nums3 = {1, 1, 2, 3, 4, 1, 1, 2};
        findTwoOddNumber(nums3);
        for (int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }
    }

    public static int findOddNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor = eor ^ nums[i];
        }
        return eor;
    }

    public static void find2OddNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        int eorPi = 0;
        eorPi = eor & (~eor + 1);

        int eor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((eorPi & nums[i]) == 0) {
                eor2 ^= nums[i];
            }
        }
        res[0] = eor2;
        res[1] = eor2 ^ eor;
    }
    public static void findTwoOddNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }

        int rightOne = eor & (~eor + 1);

        int eor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 1) {
                eor2 ^= num;
            }
        }
        int eor3 = eor2 ^ eor;
        res[0] = eor2;
        res[1] = eor3;
    }
}
