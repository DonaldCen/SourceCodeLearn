package com.learn.donald.algorithm.sort.bubble;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 14:37
 * @Desc: 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
