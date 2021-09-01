package com.learn.donald.algorithm.sort.select;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 19:16
 * @Desc: 选择排序
 */
public class SelectSort {

    /**
     * 思想：
     * 找出一个最小（或者最大的）值，次小的，第三小的...等等，然后放到相对应的位置
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
