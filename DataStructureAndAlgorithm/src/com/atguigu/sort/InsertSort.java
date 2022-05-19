package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int []arr = {101, 34, 119, 1, -1, 89};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1str = simpleDateFormat.format(date);
        System.out.println(date1str);
        insertSort(arr);
        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println(date2str);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;
//
//            System.out.println(Arrays.toString(arr));
        }
//        //第一轮
//        int insertVal = arr[1];
//        int insertIndex = 1 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println(Arrays.toString(arr));
    }
}
