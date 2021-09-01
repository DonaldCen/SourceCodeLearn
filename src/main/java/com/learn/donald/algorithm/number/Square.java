package com.learn.donald.algorithm.number;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/10 11:38
 * @Desc: 求平方根
 */
public class Square {

    public static void main(String[] args) {
        System.out.println(dichotomy(25));
    }

    /**
     * 二分法求平方根
     */
    public static double dichotomy(double n) {
        double low = 0,high = n;
        while (low <= high ){
            double mid = (low + high) / 2.0 ;
            double value = mid * mid;
            if(value == n){
                return mid;
            }
            double abs = Math.abs(value - n);
            if( abs <= 0.1 ){
                return mid;
            }
            if(value > n){
                high = mid;

            }else {
                low = mid;
            }
        }
        return 0;
    }

    public static double newTon(double n,double n1){

        return 0;
    }

}
