package com.atguigu.circlearrayqueue;

import java.util.Scanner;

@SuppressWarnings({"all"})
public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(4);
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
    private int front; // front 变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr【front】，front的初始值=0
    private int rear; //  rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个地方作为约定来取模， rear的初始值= 0
    private int[] arr; //该数据用于存放数据， 模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必修考虑取模
        System.out.println("rear=" +rear);
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if(isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("queue is empty");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1。 先把front对应的值保留到一个临时变量
        //2。 将front后移，考虑取模
        //3。 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历队列
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }

        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr["+ i % maxSize +"]=" + arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size() {
        //rear = 0
        //front = 2
        //maxsize = 3
        return (rear + maxSize - front) % maxSize; // 有效数据=
    }

    //显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front];
    }
}