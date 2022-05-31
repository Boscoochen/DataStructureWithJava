package com.atguigu.tree;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
    }

    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
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
