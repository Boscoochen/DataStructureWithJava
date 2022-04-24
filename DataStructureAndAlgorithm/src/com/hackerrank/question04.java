package com.hackerrank;

public class question04 {
    public static void main(String[] args) {
        String[] tools = {"a", "b", "c", "d", "e", "f", "f"};

        String target = "e";
        int stringLen = tools.length;


        int startIndex = 2;
        int left = startIndex;
        int right = startIndex;
        int result1 = 0;
        int result2 = 0;
        boolean check1 = false;
        boolean check2 = false;
        while (true) {
            if (tools[left].equals(target)) {
                check1 = true;
            }
            if (tools[right].equals(target)) {
                check2 = true;
            }

            if (!check1) {
                result1++;
                left--;
            }
            if (!check2) {
                result2++;
                right++;
            }

            if (left < 0) {
                left = stringLen - 1;
            }
            if (right > stringLen - 1) {
                right = 0;
            }

            if (check1 && check2) {
                break;
            }
        }

        if (result1 < result2) {
            System.out.println(result1);
        } else {
            System.out.println(result2);
        }
    }
}
