package com.CognizantCodingQuestion;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void question2() {
        int[] array = {1, 2, 3, 1, 2, 1, 3, 1};
        HashMap map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                //1=1
                //2=1
                //3=1
                map.put(array[i], 1);
            } else {
                for (Object key : map.keySet()) {
                    if ((int) key == array[i]) {
                        map.put(key, (int) map.get(key) + 1);
                    }
                }
            }
        }
        System.out.println(map);
    }
}
