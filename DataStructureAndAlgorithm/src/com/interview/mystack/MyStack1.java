package com.interview.mystack;

import java.util.Stack;



public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(-2);
        System.out.println("min=" + myStack1.getmin());
    }

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if(newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if(this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.getmin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }

    public void show() {
        while (!stackData.isEmpty()) {
            int num = stackData.pop();
            System.out.println(num);
        }
    }
}
