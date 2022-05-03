package com.atguigu.stack;

//定义一个ArrayStack 表示栈
@SuppressWarnings({"all"})
class ArrayStackDemo {

}

//定义一个ArrayStack 表示栈
@SuppressWarnings({"all"})
class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据就放在该数组
    private int top = -1; //top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop，将栈顶的数据返回
    public int pop() {
        //先判断是否为空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况【遍历栈, 遍历时，需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack=" + i + ":" + stack[i]);
        }
    }
}
