package com.learn.donald.algorithm.sort;

import com.learn.donald.algorithm.sort.bubble.BubbleSort;
import com.learn.donald.algorithm.sort.insert.InsertSort;
import com.learn.donald.algorithm.sort.merge.MergeSort;
import com.learn.donald.algorithm.sort.radix.RadixSort;
import com.learn.donald.algorithm.sort.select.SelectSort;
import com.learn.donald.algorithm.sort.shell.ShellSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 14:37
 * @Desc: 排序算法测试
 */
public class SortMain {
    private static final int MAX = 60_000_000;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final int[] lessArray = getLessArray();
    private static final int[] moreArray = getMoreArray();

    public static void main(String[] args) {
        System.out.println("开始时间：" + dateFormat.format(new Date()));
        // 冒泡排序 80000 条 13s，最坏时间复杂度为O(n2). 算法的平均时间复杂度为O(n2) .冒泡排序最好的时间复杂度为O(n).
//        BubbleSort.sort(moreArray);

        // 选择排序 80000 条 5s,时间复杂度O(n^2)  时间复杂度最好和最坏都是O(N2)
//        SelectSort.sort(lessArray);

        //插入排序 80000 条 1s，时间复杂度O(n^2) 时间复杂度最好的情况是O(N),最差的情况是O(N2)
//        InsertSort.sort(moreArray);

        //希尔排序 8000000 条 2s
//        ShellSort.sort(moreArray);

        MergeSort.sort(lessArray);
//        System.out.println(Arrays.toString(lessArray));
        System.out.println("结束时间：" + dateFormat.format(new Date()));


        //基数排序 6千万数据，6s
        /*RadixSort.sort(lessArray);
        System.out.println(Arrays.toString(lessArray));
        System.out.println("结束时间：" + dateFormat.format(new Date()));*/
    }

    private static int[] getLessArray() {
        return new int[]{11, 5, 9, 8, 33, 88, 1, -1, -99, -88,-19999};
    }

    private static int[] getMoreArray() {
        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = (int) (Math.random() * MAX);
        }
        return arr;
    }
}
