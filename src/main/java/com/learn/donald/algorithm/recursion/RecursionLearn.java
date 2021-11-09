package com.learn.donald.algorithm.recursion;

/**
 * @Author: DonaldCen
 * @Date: 2021/11/9 19:47
 * @Desc: TODO
 */
public class RecursionLearn {

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }


    private static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
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
