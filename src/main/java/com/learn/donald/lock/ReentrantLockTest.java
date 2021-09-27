package com.learn.donald.lock;

import com.learn.donald.utils.IncrementData;
import com.learn.donald.utils.Print;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/27 14:20
 * @Desc: 可重入锁
 */
public class ReentrantLockTest {
    public static final int TURNS = 1000;

    public static final int THREADS = 10;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS);
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(THREADS);
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREADS; i++) {
            pool.submit(() -> {
                try {
                    for(int j = 0; j< TURNS;j++){
                        IncrementData.lockAndFastIncrease(lock);
                    }
                    Print.tco("本线程累加完成");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float time = (System.currentTimeMillis() - start) / 1000F;
        Print.tco("运行时长为："+time);
        Print.tco("累加结果为："+IncrementData.sum);
    }
}
