package com.atguigu.recursion;

public class Quene8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如 arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Quene8 quene8 = new Quene8();
        quene8.check(0);
        System.out.println(count);
    }

    private void check(int n) {
        if(n == max) { //n = 8, 其实8个皇后就既然放好
            print();
            return;
        }
        //依次放入皇后，
        for(int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            if(judge(n)){
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i; 即将第n个皇后， 放置在本行的后移的一个位置
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for(int i = 0; i < n; i++) {
            //说明
            //判断
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    //写一个方法， 可以将皇后摆放的位置输出
    private void print() {
        count++;
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}





















