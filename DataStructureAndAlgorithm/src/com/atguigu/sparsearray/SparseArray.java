package com.atguigu.sparsearray;

@SuppressWarnings({"all"})
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1表示黑子 2 表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        for (int[] row: chessArr1) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + "\t");
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组
        //1, 先遍历二维数组 得到非 0 数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        //2， 创建对应的稀疏数组
        int sparsearray[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparsearray[0][0] = 11;
        sparsearray[0][1] = 11;
        sparsearray[0][2] = sum;

        //遍历二维数组，将非0的值放到sparsearray中
        int count = 0; //count 用于记录第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparsearray[count][0] = i;
                    sparsearray[count][1] = j;
                    sparsearray[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("=======sparse array======");
        for (int[] row: sparsearray) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + "\t");
            }
            System.out.println();
        }

        //将稀疏数组 恢复成原始的样子
        //1。先读取稀疏数组的第一行， 根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparsearray[0][0]][sparsearray[0][1]];
        //2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组 即可
        for (int i = 1; i < sparsearray.length; i++) {
            chessArr2[sparsearray[i][0]][sparsearray[i][1]] = sparsearray[i][2];
        }

        //输出chessArr2数组的形式
        System.out.println("=======chessarr2======");
        for (int[] row: chessArr2) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + "\t");
            }
            System.out.println();
        }
    }
}
