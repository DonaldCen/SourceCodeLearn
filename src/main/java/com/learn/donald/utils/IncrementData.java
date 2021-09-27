package com.learn.donald.utils;

import java.util.concurrent.locks.Lock;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/27 16:03
 * @Desc:
 */
public class IncrementData {

    public static int sum = 0;

    public static void lockAndFastIncrease(Lock lock){
        lock.lock();
        try {
            sum++;
        } finally {
            lock.unlock();
        }
    }
}
