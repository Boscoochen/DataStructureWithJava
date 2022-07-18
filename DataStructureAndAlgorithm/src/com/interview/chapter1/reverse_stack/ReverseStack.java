package com.interview.chapter1.reverse_stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()) {
            int top = stack.pop();
            System.out.println(top);
        }
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        //3
        //2  2
        //1  1  1
        int result = stack.pop();
        //result=3  第一轮
        //result=2 第二轮
        //result=1 第三轮
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            //last = 1
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
