package com.hackerrank;

import java.util.Stack;

public class question02 {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(1.1);
        st.push('z');
        st.push("Hello");
        for (var e : st
             ) {
            System.out.println(e);
        }
    }
}
