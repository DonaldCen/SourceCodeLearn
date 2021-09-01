package com.learn.donald.algorithm.leetcode;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/10 17:37
 * @Desc: 删除排序数组中的重复项
 */
public class LeetCode03 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,3,3,4,5};
        System.out.println(get1(nums));
    }

    /**
     * 双指针算法
     * 一个快指针，一个慢指针
     * 慢指针指向数组第一个元素，慢指针指向数组第二个元素
     * 如果两个元素不相等，就一起前进一格
     * 否则就慢指针不动，快指针进一格
     * 官方双指针算法
     * 数组完成排序后，我们可以放置两个指针 i 和 j,其中 i 是慢指针，而j是快指针。只要nums[i]+nums[j]
     * 我们就增加j跳过重复项；
     * 当遇到nums[j] != nums[i]时，跳过重复项的运行结束，必须把num[j]的值复制到nums[i+1]，然后递增i
     * 接着再次重复相同的过程，直到j到达数组的末尾为止
     */
    public static int get1(int[] nums){
        if(nums.length < 2){
            return nums.length;
        }
        int low = 0;
        for(int fast = 1; fast < nums.length;fast++){
            if(nums[low] != nums[fast]){
                low++;
                nums[low] = nums[fast];
            }
        }
        return low + 1;
    }


}
