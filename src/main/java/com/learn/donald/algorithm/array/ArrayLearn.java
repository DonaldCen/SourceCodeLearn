package com.learn.donald.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DonaldCen
 * @Date: 2021/11/9 17:10
 * @Desc: TODO
 */
public class ArrayLearn {

    public static void main(String[] args) {
        /*DynamicArray array = new DynamicArray();
        for(int i = 0;i < 10;i++){
            array.add(i+"");
        }
        System.out.println("size:"+array.getArraySize());
        array.add("11");
        System.out.println("size:"+array.getArraySize());
        array.remove(5);
        System.out.println("size:"+array.getArraySize());*/

        int[] a = {1,22,33,45,55};
        int[] b = {2,3,4};

        System.out.println(Arrays.toString(merge(a,b)));

    }

    private static int[] merge(int[] a,int[] b){
        int[] arr = new int[a.length + b.length];
        int t1 = 0,t2 = 0,arr1 = 0;
        while (t1 < a.length && t2 < b.length){
            if(a[t1] < b[t2]){
                arr[arr1++] = a[t1++];
            } else {
                arr[arr1++] = b[t2++];
            }
        }
        while (t1 < a.length){
            arr[arr1++] = a[t1++];
        }
        while (t2 < b.length){
            arr[arr1++] = b[t2++];
        }
        return arr;
    }
}
