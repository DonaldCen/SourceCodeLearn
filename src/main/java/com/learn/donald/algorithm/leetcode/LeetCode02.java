package com.learn.donald.algorithm.leetcode;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/10 16:01
 * @Desc: 统计n以内的素数的个数
 * 素数：只能被1和自身整除的自然数，0,1除外
 */
public class LeetCode02 {

    public static void main(String[] args) {
        System.out.println(get3(100));
    }

    /**
     * 暴力算法
     * 空间复杂度O(1)
     * 时间复杂度O(n * n)
     */
    public static int get1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i)?1:0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃式筛选法
     * 用空间换时间
     * 空间复杂度是O(n)
     * 时间复杂度是O(n)
     * 算法很多技巧，就是借助 map,list,array等，作为标志位，提供时间复杂度
     * 循环中，j=2*i;j<n;j+=n 是什么意思的呢？意思就是 2*i + i --》 3i
     * 即递增系数，是一个算法的技巧
     */
    public static int get2(int n){
        //boolean数组
        boolean[] isPrime = new boolean[n];//false代表素数
        int count = 0;
        for(int i = 2;i<n;i++){
            if(!isPrime[i]){
                count++;
                for(int j = 2 * i;j < n;j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * 这里是  get2的一个优化，优化点为：
     * int j = 2 * i;j < n;j+=i  变成
     * int j = i * i;j < n;j+=i
     * 为啥是这样的呢，因为 从一开始，很多比i小的系数乘积都已经遍历过了，没必要再遍历一次
     * 当i=2的时候，2 * 2,2*3,2*4,2*5,2*6
     * 当i=3的时候，3 * 2,3*3,3*4,3*5,3*6
     * 2*3 和 3*2 是一样的，完全没必要再遍历一次
     */
    public static int get3(int n){
        //boolean数组
        boolean[] isPrime = new boolean[n];//false代表素数
        int count = 0;
        for(int i = 2;i<n;i++){
            if(!isPrime[i]){
                count++;
                for(int j = i * i;j < n;j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
