package com.CognizantCodingQuestion;

import java.util.ArrayList;

public class Question {
    public static void main(String[] args) {
        String string1 = "cognizant technology solution";
        String[] arr = string1.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("technology")) {
                System.out.println(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) == 'n') {
                list.add(i);
            }
        }
        System.out.println(list);
        String target = "gy solution";
        int k = 0;
        String result = "";
        for(int i = 0; i < string1.length(); i++) {
            int j = i;
            while ((j < string1.length() && k < target.length()) && string1.charAt(j) == target.charAt(k)) {
                result += string1.charAt(j);
                k++;
                j++;
            }
            if(k != target.length()) {
                k = 0;
                result = "";
            }
        }
        System.out.println(result);
        System.out.println(k);
    }
}
