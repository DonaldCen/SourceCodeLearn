package com.learn.donald.algorithm.sort.shell;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 23:26
 * @Desc: 希尔排序
 */
public class ShellSort {

    public static void sort(int[] arr) {
        for (int m = arr.length / 2; m > 0; m /= 2) {
            for (int j = m; j < arr.length; j++) {
                int insertValue = arr[j];
                int insertIndex = j - m;
                if(insertValue < arr[insertIndex]){
                    while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                        arr[insertIndex + m] = arr[insertIndex];
                        insertIndex -= m;
                    }
                    arr[insertIndex + m] = insertValue;
                }

            }
        }
    }
}
