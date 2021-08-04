package algorithm.number;

/**
 * @Description
 * @Author <a href="mailto:cenyingqiang@wxchina.com">yingqiang.Cen</a>
 * @Date 2021/8/5
 * @Version 1.0.0
 */
public class PrimeNumber {


    public static void main(String[] args) {

        System.out.println(esFilter(100));
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
}
