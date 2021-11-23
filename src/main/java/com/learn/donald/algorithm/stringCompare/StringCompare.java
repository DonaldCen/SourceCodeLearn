package com.learn.donald.algorithm.stringCompare;

/**
 * @Author: DonaldCen
 * @Date: 2021/11/16 14:19
 * @Desc:
 */
public class StringCompare {

    public static void main(String[] args) {
        String str1 = "abcdefghijk";
        String str2 = "hijk";
        int index = isSame(str1, str2);
        System.out.println(index);
    }

    private static int isSame(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        for (int i = 0; i < n - m + 1; i++) {
            int start = i;
            int last = i + m;
            String temp = str1.substring(start, last);
            if(temp.equals(str2)){
                return i;
            }
        }
        return -1;
    }
}
