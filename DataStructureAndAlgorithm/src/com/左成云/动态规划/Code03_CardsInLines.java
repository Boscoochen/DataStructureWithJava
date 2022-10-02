package com.左成云.动态规划;

public class Code03_CardsInLines {
    public static void main(String[] args) {
//        int[] arr = {50, 100, 20, 10};
//        int[] arr = {1, 100, 1};
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};

//        int N = arr.length;
//        int[][] fMap = new int[N][N];
//        int[][] gMap = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                fMap[i][j] = -1;
//                gMap[i][j] = -1;
//            }
//        }
//
//        int first = f2(arr, 0, arr.length - 1, fMap, gMap);
//        int second = g2(arr, 0, arr.length -1, fMap, gMap);
//        System.out.println(Math.max(first, second));
//        int[] arr = {7, 4, 16, 15, 1};
        System.out.println(win3(arr));
    }


    //先手后手先手后手。。。。。。循环直到只剩下一个数
    public static int firstDraw(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }

        int firstLeft = arr[L] + secondDraw(arr, L+1, R);
        int firstRight = arr[R] + secondDraw(arr, L, R - 1);

        return Math.max(firstLeft, firstRight);
    }

    public static int secondDraw(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int secondLeft =  firstDraw(arr, L+1, R);
        int secondRight = firstDraw(arr, L, R - 1);
        //双方都是绝顶聪明，我是后手，也预测到对方拿最优，所以min
        return Math.min(secondLeft, secondRight);
    }

    public static int f2(int[] arr, int L, int R, int[][] fMap, int[][] gMap) {
        if (fMap[L][R] != -1) {
            return fMap[L][R];
        }

        int ans = 0;

        if (L == R) {
            ans = arr[L];
        } else {

            int firstLeft = arr[L] + g2(arr, L + 1, R, fMap, gMap);
            int firstRight = arr[R] + g2(arr, L, R - 1, fMap, gMap);
            ans = Math.max(firstLeft, firstRight);
        }

        fMap[L][R] = ans;

        return ans;
    }

    public static int g2(int[] arr, int L, int R, int[][] fMap, int[][] gMap) {
        if (gMap[L][R] != -1) {
            return gMap[L][R];
        }

        int ans = 0;

        if (L != R) {
            int secondLeft =  f2(arr, L+1, R, fMap, gMap);
            int secondRight = f2(arr, L, R - 1, fMap, gMap);
            ans = Math.min(secondLeft, secondRight);
        }

        gMap[L][R] = ans;

        //双方都是绝顶聪明，我是后手，也预测到对方拿最优，所以min
        return ans;
    }

    public static int win3(int[] arr) {
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] gMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            fMap[i][i] = arr[i];
        }


        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fMap[L][R] = Math.max(arr[L] + gMap[L+1][R], arr[R] + gMap[L][R-1]);
                gMap[L][R] = Math.min(fMap[L+1][R], fMap[L][R-1]);
                L++;
                R++;
            }
        }
        return Math.max(fMap[0][N-1],gMap[0][N-1]);
    }
}
