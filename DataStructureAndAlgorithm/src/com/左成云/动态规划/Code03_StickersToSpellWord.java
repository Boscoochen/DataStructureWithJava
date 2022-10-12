package com.左成云.动态规划;

import java.util.ArrayList;
import java.util.HashMap;

public class Code03_StickersToSpellWord {
    public static void main(String[] args) {
        String[] strArr = {"abc", "bba", "cck"};
        String str = "aabbbbc";

        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(str.charAt(i));
        }
        System.out.println(arrayList);
//        int res = way(strArr, arrayList);
//        int res = process1(strArr, str);

        int[][] stickers = new int[strArr.length][26];
        for (int i = 0; i < strArr.length; i++) {
            char[] charSticker = strArr[i].toCharArray();
            for (int j = 0; j < charSticker.length; j++) {
                stickers[i][charSticker[j] - 'a']++;
            }
        }
//        int res = process2(stickers, str);
//        int res = process2(stickers, str);
        System.out.println(minSticker3(strArr, str));
    }

//    public static int way(String[] strArr, ArrayList str) {
//        if (str.size() == 0) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < strArr.length; i++) {
//            ArrayList rest = removeOriginal(strArr[i], str);
////            System.out.println(rest);
//            if (str.size() != rest.size()) {
//                min = Math.min(min, way(strArr, rest));
//            }
//        }
//        return min + (min == Integer.MAX_VALUE ? 0 : 1);
//    }
//
//    public static ArrayList removeOriginal(String strArr, ArrayList str) {
//        char[] charArray = strArr.toCharArray();
//        ArrayList<Character> newList = new ArrayList<>();
//        for (int i = 0; i < str.size(); i++) {
//            newList.add((Character)str.get(i));
//        }
//        for (int i = 0; i < charArray.length; i++) {
//            for (int j = 0; j < newList.size(); j++) {
//                if (charArray[i] == (Character)newList.get(j)) {
//                    newList.remove(j);
//                    break;
//                }
//            }
//        }
//        return newList;
//    }


    public static int process1(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String first : stickers) {
            String rest = minus(target, first);
//            System.out.println(rest.toString());

            if (rest.length() != target.length()) {
                min = Math.min(min, process1(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];
        for (char cha : str1) {
            count[cha - 'a']++;
        }
        for (char cha : str2) {
            count[cha - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    builder.append((char) (i + 'a'));
                }
            }
        }

        return builder.toString();
    }

    public static int process2(int[][] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        char[] arrTarget = target.toCharArray();

        int[] rest = new int[26];
        for (int j = 0; j < arrTarget.length; j++) {
            rest[arrTarget[j] - 'a']++;
        }

        for (int i = 0; i < stickers.length; i++) {
            if (stickers[i][arrTarget[0] - 'a'] > 0) {
                //拼接剩余
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (rest[j] > 0) {
                        int nums = rest[j] - stickers[i][j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }

                String restString = builder.toString();
                min = Math.min(min, process2(stickers, restString));
            }
        }

        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static int minSticker3(String[] stickers, String target) {
        int N = stickers.length;
        int[][] counts = new int[N][26];
        for (int i = 0; i < N; i++) {
            char[] str = stickers[i].toCharArray();
            for (char cha : str) {
                counts[i][cha - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        int ans = process3(counts, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static int process3(int[][] stickers, String t, HashMap<String, Integer> dp) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }

        char[] target = t.toCharArray();
        int[] tcounts = new int[26];
        for (char cha : target) {
            tcounts[cha - 'a']++;
        }
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] sticker = stickers[i];
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (tcounts[j] > 0) {
                        int nums = tcounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process3(stickers, rest, dp));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(t, ans);
        return ans;
    }
}