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
    public static void quickSort(int arr[], int left, int right) {
        int l = left;
        int r = right;

        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l >= r说明pivot的左右两边的值，已经按照左边全部是小于等于pivot，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r--;
            }
            if(arr[r] == pivot){
                l++;
            }

            if(l == r){
                l++;
                r--;
            }
            if(left < r){
                quickSort(arr,left,r);
            }
            if(right > l){
                quickSort(arr,l,right);
            }
        }

    }

    public static void sort(int a[]) {
        quickSort(a, 0, a.length - 1);
    }
}
