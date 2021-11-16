package com.learn.donald.algorithm.array;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

        /*int[] a = {1,22,33,45,55};
        int[] b = {2,3,4};

        System.out.println(Arrays.toString(merge(a,b)));*/
        /*int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));*/


        /*int[][] in = new int[][]{{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] arr = matrixReshape(in, r, c);
        Arrays.stream(arr).forEach(m -> {
            System.out.println(Arrays.toString(m));
        });*/
        /*int[] arr = new int[]{1,0,1,0,0,0,1};
        int count = findMaxConsecutiveOnes(arr);
        System.out.println(count);*/
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean b = searchMatrix2(arr, 5);
        System.out.println(b);
    }

    /**
     * 合并两个有序数组
     *
     * @param a
     * @param b
     * @return
     */
    private static int[] merge(int[] a, int[] b) {
        int[] arr = new int[a.length + b.length];
        int t1 = 0, t2 = 0, arr1 = 0;
        while (t1 < a.length && t2 < b.length) {
            if (a[t1] < b[t2]) {
                arr[arr1++] = a[t1++];
            } else {
                arr[arr1++] = b[t2++];
            }
        }
        while (t1 < a.length) {
            arr[arr1++] = a[t1++];
        }
        while (t2 < b.length) {
            arr[arr1++] = b[t2++];
        }
        return arr;
    }

    /**
     * 把所有的0移动到后面
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v != 0) {
                nums[index++] = v;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 重塑矩阵
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] arr = new int[r][c];
        for (int index = 0; index < m * n; index++) {
            arr[index / c][index % c] = mat[index / n][index % n];
        }
        return arr;
    }

    /**
     * 最大连续 1 的个数
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (i < nums.length && nums[i] == 1) {
                count++;
                i++;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row:matrix){
            int index = search(row, target);
            if(index >= 0){
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }


    private static int search(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start + end) / 2;
            int midVal = arr[mid];
            if(midVal == target){
                return mid;
            }else if(target < midVal){
                end = mid - 1;
            } else {
                start = mid + 1;

            }
        }
        return -1;
    }

    public int kthSmallest(int[][] matrix, int k) {


        return 0;
    }


    @Data
    class MatrixItem implements Comparator<MatrixItem> {
        private int x;
        private int y;
        private int val;

        public MatrixItem(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compare(MatrixItem o1, MatrixItem o2) {
            return o1.val - o2.val;
        }
    }
}
