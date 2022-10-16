package com.左成云.动态规划;

import javax.crypto.Mac;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目
 * 数组arr代表每一个咖啡机冲一杯咖啡的时间，每个咖啡机只能串行的制造咖啡
 * 现在有n个人需要喝咖啡，只能用咖啡机来制造咖啡
 * 认为每个人喝咖啡的时间非常短，冲好的时间即是喝完的时间
 * 每个人喝完之后咖啡杯可以选择洗或者自然挥发干净，只有一台洗咖啡杯的机器，只能串行的洗咖啡杯
 * 洗杯子的机器洗完一个杯子时间为a，任何一个杯子自然挥发干净的时间为b
 * 四个参数：arr，n，a，b
 * 假设时间点从0开始，返回所有人喝完咖啡并洗完咖啡杯的全部过程结束，至少来到什么时间点
 */
public class Code03_Coffee {


    public static class Machine {
        public int timePoint;
        public int workTime;

        public Machine(int t, int w) {
            timePoint = t;
            workTime = w;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {
        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.timePoint + o1.workTime) - (o2.timePoint + o2.workTime);
        }
    }

    public static int minTime2(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heap.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heap.add(cur);
        }
        return bestTime(drinks, a, b, 0, 0);
    }

    /**
     *
     * @param drinks 所有杯子可以开始洗的时间
     * @param wash 单杯洗干净的时间 （串行）
     * @param air 挥发干净的时间
     * @param index
     * @param free 洗的机器什么时候可用
     * @return drinks[index......]都变干净，最早的结束时间 （返回）
     */
    public static int bestTime(int[] drinks, int wash, int air, int index, int free) {
        if (index == drinks.length) {
            return 0;
        }
        int selfClean1 = Math.max(drinks[index], free) + wash;
        int restClean1 = bestTime(drinks, wash, air, index+1, selfClean1);
        int p1 = Math.max(selfClean1, restClean1);

        int selfClean2 = drinks[index] + air;
        int restClean2 = bestTime(drinks, wash, air, index+1, free);
        int p2 = Math.max(selfClean2, restClean2);

        return Math.min(p1, p2);
    }


    public static int bestTimeDp(int[] drinks, int wash, int air) {
        int N = drinks.length;
        int maxFree = 0;
        for (int i = 0; i < drinks.length; i++) {
            maxFree = Math.max(maxFree, drinks[i]) + wash;
        }

        int[][] dp = new int[N + 1][maxFree + 1];


        return dp[0][0];
    }
}

