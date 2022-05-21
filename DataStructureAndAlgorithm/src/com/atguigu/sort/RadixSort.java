package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }



    public static void radixSort(int[] arr) {

        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();


        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];

        for(int i = 0, n = 1; i < maxLength; i++, n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCount[k] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }

//        //第一轮
//        for(int j = 0; j < arr.length; j++) {
//            int digitOfElement = arr[j] % 10;
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
//            bucketElementCount[digitOfElement]++;
//        }
//
//        int index = 0;
//        for(int k = 0; k < bucketElementCount.length; k++) {
//            if(bucketElementCount[k] != 0) {
//                for(int l = 0; l < bucketElementCount[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index ++;
//                }
//            }
//            bucketElementCount[k] = 0;
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        for(int j = 0; j < arr.length; j++) {
//            int digitOfElement = arr[j] / 10 % 10;
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
//            bucketElementCount[digitOfElement]++;
//        }
//
//        index = 0;
//        for(int k = 0; k < bucketElementCount.length; k++) {
//            if(bucketElementCount[k] != 0) {
//                for(int l = 0; l < bucketElementCount[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index ++;
//                }
//            }
//            bucketElementCount[k] = 0;
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        for(int j = 0; j < arr.length; j++) {
//            int digitOfElement = arr[j] / 100 % 10;
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
//            bucketElementCount[digitOfElement]++;
//        }
//
//        index = 0;
//        for(int k = 0; k < bucketElementCount.length; k++) {
//            if(bucketElementCount[k] != 0) {
//                for(int l = 0; l < bucketElementCount[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index ++;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
