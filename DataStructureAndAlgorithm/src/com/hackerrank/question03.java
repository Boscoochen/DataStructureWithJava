package com.hackerrank;

import java.util.*;

@SuppressWarnings({"all"})
public class question03 {
    public static void main(String[] args) {
        String text = "heolloworld";
        LinkedHashMap hashMap = new LinkedHashMap();

        for (int i = 0; i < text.length(); i++) {
            if(hashMap.containsKey(text.charAt(i))) {
                hashMap.put(text.charAt(i), (int)hashMap.get(text.charAt(i)) + 1);
            }else {
                hashMap.put(text.charAt(i), 1);
            }
        }

        int temp = 0;
        Iterator iterator = hashMap.keySet().iterator();


        while (iterator.hasNext()) {
            Object next =  iterator.next();
            if(temp < (int)hashMap.get(next)) {
                temp = (int)hashMap.get(next);
            }
            System.out.println(next + " " + hashMap.get(next));
        }

        System.out.println(temp);


    }
}
