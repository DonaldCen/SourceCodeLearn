package com.learn.donald.algorithm.sort.merge;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 23:26
 * @Desc: 归并排序
 */
public class MergeSort {

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 如果要排序一个数组，我们先把数组从中间分成前后两部分，
     * 然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
     */
    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        //先归左边
        mergeSort(arr, start, mid, temp);
        //接着归右边
        mergeSort(arr, mid + 1, end, temp);
        //合并
        merge(arr, start, mid, end, temp);
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int tempIndex = 0;//temp数组指针
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[tempIndex++] = arr[i++];
            } else {
                temp[tempIndex++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[tempIndex++] = arr[i++];
        }
        while (j <= end) {
            temp[tempIndex++] = arr[j++];
        }
        tempIndex = 0;
        int tempStart = start;
        while (tempStart <= end) {
            arr[tempStart++] = temp[tempIndex++];
        }

    }
}
