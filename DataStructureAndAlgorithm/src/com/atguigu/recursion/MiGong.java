package com.atguigu.recursion;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1 表示1墙
        //上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //再加两个挡板测试回溯
//        map[1][2] = 1;
//        map[2][2] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //策略
        if (setWay2(map,1,1)) {
            System.out.println("找到路了");
        }else {
            System.out.println("没有找到路");
        }
        //输出新的地图， 小球走过， 并标识过的地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1。map 表示地图
    //2。i，j 表示从地图的哪个位置开始出发 （1，1）
    //3。如果小球能到map[6][5] 位置， 则说明通路找到
    //4。约定：当map[i][j] 为0表示该点没有走过 当为1表示墙，2 表示通路可以走， 3 表示该点已经走过，但是走不通
    //5。在走迷宫时，需要确定一个策略（方法）下-》右-》上-》左，如果该点走不通，再回溯
    /**
     *
     * @param map 表示地图
     * @param i  i 从哪个位置开始找
     * @param j  j
     * @return   如果找到通路，就返回true， 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2) { //通路已经找到ok
            return true;
        }else {
            if(map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 下-》右-》上-》左
                map[i][j] = 2; //假定该点是可以走通
                if(setWay(map, i+1, j)) { //向下走
                    return true;
                }else if(setWay(map, i, j+1)) { //向右走
                    return true;
                }else if(setWay(map, i-1, j)) { //向上走
                    return true;
                }else if(setWay(map, i, j-1)) { //向左走
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }
        }
        return false;
    }

    //修改找路策略， 上右下左
    public static boolean setWay2(int[][] map, int i, int j) {
        if(map[6][5] == 2) { //通路已经找到ok
            return true;
        }else {
            if(map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 上右下左
                map[i][j] = 2; //假定该点是可以走通
                if(setWay2(map, i-1, j)) { //向上走
                    return true;
                }else if(setWay2(map, i, j+1)) { //向右走
                    return true;
                }else if(setWay2(map, i+1, j)) { //向下走
                    return true;
                }else if(setWay2(map, i, j-1)) { //向左走
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }
        }
        return false;
    }
}
