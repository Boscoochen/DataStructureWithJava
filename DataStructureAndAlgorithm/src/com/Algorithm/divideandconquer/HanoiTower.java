package com.Algorithm.divideandconquer;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if(num == 1) {
            System.out.println("第一个盘从" + a + "->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
 }






//hanoiTower(1, A, B, C)
//hanoiTower(2, B, A, C)
//hanoiTower(3, A, B, C)


//output
//第一个盘从A->C
//第2个盘从A->B
//第一个盘从C->B
//第3个盘从A->C
//第一个盘从B->A
//第2个盘从B->C
//第一个盘从A->C