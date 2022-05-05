package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"all"})
public class PolandNotation {
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //（3+4）x5-6 =》"3 4 + 5 * 6 -"
        //说明为了方便， 逆波兰表达式 的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 - ";

        //思路
        //1。先将 "3 4 + 5 x 6 -  " =》 放到ArrayList中
        //2。将ArrayList 传递给一个方法，遍历ArrayList 配合栈 完成计算

        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        int res = calculate(rpnList);
        System.out.println("result= " + res);
    }

    //将一个逆波兰表达式，依次将数据和运算符 放到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    /*
        1）从左至右扫描， 将3和4压入堆栈
         2）  遇到+运算符，因此弹出4和3 （4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈
         3）  将5如栈；
         4）  接下来是x运算符，因此弹出5和7，计算出7x5=35，将35入栈
         5）  将6入栈
         6）  最后-运算符，计算35-6的值，即29，由此得出最终结果
     */

    public static int calculate(List<String> ls) {
        //创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for(String item : ls) {
            //这里使用正则表达式来取数
            if(item.matches("\\d+")) {
                //入栈
                stack.push(item);
            }else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + ""); //整数转字符串
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
