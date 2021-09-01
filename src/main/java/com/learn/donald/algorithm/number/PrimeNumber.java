package com.learn.donald.algorithm.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author <a href="mailto:cenyingqiang@wxchina.com">yingqiang.Cen</a>
 * @Date 2021/8/5
 * @Version 1.0.0
 */
public class PrimeNumber {


    public static void main(String[] args) {

//        System.out.println(esFilter(100));

        /*int[] arr = {5, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));*/

//        System.out.println(minFlipsMonoIncr("00011000"));

        System.out.println(reverseWords(" 1 "));
    }

    /**
     * 埃筛法
     * 第二个for循环是缩短遍历元素的个数，把 0~n ,和 j 相关的合数都找出来，然后标记起来
     * 而 第二个 for 循环中，j=2*i;j<n;j+=n 是什么意思的呢？意思就是 2*i + i --》 3i
     * 就是要保证 i不变，x 从 2 ~ z ,其中 x * i < n
     */
    public static int esFilter(int n){
        int count = 0;
        boolean[] isPrime = new boolean[n];
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
     * 题目中指出长度为n,且数组里面的数据在 0~n-1的范围内
     * 可以利用相同的值，放到数组中会放到相同的index，然后在这个index保存出现的次数
     */
    public static int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(++count[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }

    public static String reverseWords(String s) {
        s = s.trim();
        if(s.length() <= 2){
            return s.trim();
        }
        int n = s.length();
        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 1;
        while (l <= n-1 && r <= n-1){
            if(s.charAt(r) == ' '){
                r++;
                while (s.charAt(r) == ' '){
                    r++;
                }
                String world = s.substring(l, r);
                list.add(world.trim());

                l = r;
                r++;
            }
            r++;
            if(r == n){
                String world = s.substring(l, r);
                list.add(world.trim());
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = list.size()-1;i>=0;i--){
            if(list.get(i) != null){
                result.append(list.get(i)).append(" ");
            }
        }
        return result.toString().trim();
    }
}
