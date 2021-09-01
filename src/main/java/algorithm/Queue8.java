package algorithm;

import java.util.Arrays;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/1 10:46
 * @Desc: 8皇后问题
 */
public class Queue8 {
    private static int max = 8;
    private static int[] arr = new int[max];
    private static int count = 0;
    private static int judgeCount = 0;

    public static void main(String[] args) {
        check(0);
        //92
        System.out.println(count);
        //15720
        System.out.println(judgeCount);
    }

    private static void check(int n){
        if(n == max){
            print();
            count++;
            return;
        }
        for(int i = 0;i< max;i++){
            arr[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private static void print() {
        System.out.println(Arrays.toString(arr));
    }

    private static boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
