package com.learn.donald.algorithm.sort;

import com.learn.donald.algorithm.sort.bubble.BubbleSort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 14:37
 * @Desc: 排序算法测试
 */
public class SortMain {
    private static final int MAX = 80000;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final int[] lessArray = getLessArray();
    private static final int[] moreArray = getMoreArray();

    public static void main(String[] args) {
        System.out.println("开始时间：" + dateFormat.format(new Date()));
        // 冒泡排序 80000 条 13s，时间复杂度O(n^2)
        BubbleSort.sort(moreArray);
        System.out.println("结束时间：" + dateFormat.format(new Date()));
    }

    private static int[] getLessArray() {
        return new int[]{11, 5, 9, 8, 33, 88, 1, -1, -99, -88};
    }

    private static int[] getMoreArray() {
        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = (int) (Math.random() * MAX);
        }
        return arr;
    }
}
