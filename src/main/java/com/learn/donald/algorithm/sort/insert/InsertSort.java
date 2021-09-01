package com.learn.donald.algorithm.sort.insert;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 19:40
 * @Desc: 插入排序
 */
public class InsertSort {

    /**
     * 思想：
     * 一个数组，视为两部分，一部分是有序的，一部分是无序的。
     * 初始状态，第一个数视为有序的，n-1为无序的，然后遍历无序的，找到合适的位置，插入到有序的部分
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }
}
