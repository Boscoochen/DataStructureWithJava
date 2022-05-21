package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random() * 8000000);
//        }
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1str = simpleDateFormat.format(date);
//        System.out.println(date1str);
        shellSort2(arr);
//        Date date2 = new Date();
//        String date2str = simpleDateFormat.format(date2);
//        System.out.println(date2str);
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }

//        int temp = 0;
//        for(int i = 5; i < arr.length; i++) {
//            for(int j = i - 5; j >= 0; j-=5) {
//                if(arr[j] > arr[j+5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for(int i = 2; i < arr.length; i++) {
//            for(int j = i - 2; j >= 0; j-=2) {
//                if(arr[j] > arr[j+2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//
//        for(int i = 1; i < arr.length; i++) {
//            for(int j = i - 1; j >= 0; j-=1) {
//                if(arr[j] > arr[j+1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
//                if(arr[j] < arr[j - gap]) {
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = temp;
//                }
            }
        System.out.println(Arrays.toString(arr));
        }
    }

}
