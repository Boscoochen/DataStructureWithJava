package com.atguigu.queue;

import java.util.Scanner;

@SuppressWarnings({"all"})
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("添加什么数据：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是： " + res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据是：" + res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出。。");
    }
}

@SuppressWarnings({"all"})
//使用数组模拟队列， 编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据， 模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾， 指向队列尾的数据（即就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if(isFull()) {
            System.out.println("queue is full, can't add");
            return;
        }
        arr[++rear] = n; //让rear后移， 然后将n赋给arr【rea】
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if(isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("queue is empty");
        }
        return arr[++front]; //让front后移，然后return
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历队列
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+ i +"]=" + arr[i]);
        }
    }

    //显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
           throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }
}