package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = {53, 3, 542, 748, 14, 214};
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1str = simpleDateFormat.format(date);
        System.out.println(date1str);
        radixSort(arr);
        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println(date2str);
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
//            System.out.println(Arrays.toString(arr));
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
