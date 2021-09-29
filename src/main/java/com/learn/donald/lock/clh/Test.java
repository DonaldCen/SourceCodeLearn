package com.learn.donald.lock.clh;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/29 18:07
 * @Desc:
 */
public class Test {
    private static volatile int donaldCenAge = 28;

    public static void main(String[] args) {
        int age = donaldCenAge + 1;
        System.out.println(age);
    }
}
