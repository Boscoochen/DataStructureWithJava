package com.atguigu.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
//        int arr[] = {4, 6, 8, 5, 9, -1 , 90, 89, 50, -999};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1str = simpleDateFormat.format(date);
        System.out.println(date1str);
        heapSort(arr);
        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println(date2str);
    }

    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
        int temp = 0;
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for(int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

//        System.out.println("数组=" + Arrays.toString(arr));


    }

    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
