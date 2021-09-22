package com.learn.donald.algorithm.sort.quick;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 23:26
 * @Desc: 快速排序
 */
public class QuickSort {

    /**
     * 思想
     * 找出一个中心数，分为左右两部分，
     * 左边比这个数大的都移动到右边，右边比这个数小的都移动到左边
     * 然后左右两部分分别按照这个规律进行递归，直到左右部分长度都为1
     */
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        while (left < right){

        }
    }
}
