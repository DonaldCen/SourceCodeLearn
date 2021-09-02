package com.learn.donald.algorithm.sort.radix;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/2 10:04
 * @Desc: 基数排序
 */
public class RadixSort {

    /**
     * 思想：
     * 找出数组中最大的数，然后算出该数的长度，该数的长度，即为遍历的轮次
     * 第一轮 使用10个桶（每个桶就是一个一维数组），每个桶的编号分别从 0~9
     * 然后遍历数组，把每个数的个位数 对应桶的编号按顺序依次放入（如 95，放到下标为5的桶，99放到下标为9的桶）
     * 接着把10个桶 从0~9依次把数放回原数组
     * 第二轮，还是这个10个桶，只不过这次按每个数的十位数
     * 第三轮，按每个数的百位。。
     * 以此类推
     * 有负数的话，先判断有无负数
     * 有则找到最小值 数组所有数据都减去该值 也就是数组最小值会变为0
     * 接下来按正整数排序 最后数组所有数据加上原最小数 变为原有数据值
     */
    public static void sort(int[] arr) {
        //找最大的数
        int maxValue = arr[0];
        int min = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
            if (value < min) {
                min = value;
            }
        }
        //存在负数
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= min;
                maxValue -= min;
            }
        }
        //找最大数的位数
        int maxLength = (maxValue + "").length();
        //新建一个二维数组，用来保存10个桶
        int[][] bucket = new int[10][arr.length];
        //再新建一个数组，用来保存每个桶的指针（该指针用来保存每个桶元素的个数）
        int[] elements = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //计算出每个数的对应的桶序号
                int bucketIndex = arr[j] / n % 10;
                /**
                 * bucket[bucketIndex] 指明了第 bucketIndex 个桶，
                 * 而 elements[bucketIndex] 表明了 是桶里的第几个数
                 */
                bucket[bucketIndex][elements[bucketIndex]] = arr[j];
                //作为桶的指针，必须指向当前元素的下一位
                elements[bucketIndex]++;
            }
            //排完一轮，接着把10个桶中有数据的桶 从0~9依次把数放回原数组
            int t = 0;
            for (int k = 0; k < elements.length; k++) {
                int value = elements[k];
                if (value > 0) {
                    for (int l = 0; l < value; l++) {
                        arr[t] = bucket[k][l];
                        t++;
                    }
                }
                //放回去后，清空
                elements[k] = 0;
            }

        }

        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += min;
            }
        }

    }
}
