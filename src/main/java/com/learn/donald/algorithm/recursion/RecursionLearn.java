package com.learn.donald.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DonaldCen
 * @Date: 2021/11/9 19:47
 * @Desc: TODO
 */
public class RecursionLearn {

    public static void main(String[] args) {
//        System.out.println(climbStairs(45));
        int[] arr = new int[]{9,11};
        int k = 2;
        int[] result = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(result));
    }


    private static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int[] maxSlidingWindow(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = k-1;
        int arrIndex = 0;
        while (j < nums.length){
            int maxNum = nums[i];
            for(int index = i+1;index<=j;index++){
                maxNum = Math.max(maxNum,nums[index]);
            }
            list.add(maxNum);
            arrIndex++;
            j++;
            i++;
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    /**
     * 爬梯子
     */
    private static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
