package com.learn.donald.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/27 16:13
 * @Desc:
 */
public class ThreadUtil {

    private final static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void sleepMilliSeconds(int milliSecond){
        LockSupport.parkNanos(milliSecond * 1000L * 1000L);
    }

    public static boolean isInterrupted(){
        Thread t = Thread.currentThread();
        return t.isInterrupted();
    }

    public static void execute(Runnable runnable){
        pool.execute(runnable);
    }
}
