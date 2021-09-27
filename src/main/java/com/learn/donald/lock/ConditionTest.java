package com.learn.donald.lock;

import com.learn.donald.utils.Print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/27 19:22
 * @Desc:
 */
public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(waitWorker,"waitWorker");
        Thread notifyThread = new Thread(notifyWorker,"notifyWorker");
        waitThread.start();
        Thread.sleep(1000);
        notifyThread.start();
    }

    static Runnable waitWorker = new Runnable() {
        @Override
        public void run() {
            lock.lock();
            try {
                Print.tco("我是等待方");
                condition.await();
                Print.tco("收到通知，等待方继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    };

    static Runnable notifyWorker = new Runnable() {
        @Override
        public void run() {
            lock.lock();
            try {
                Print.tco("我是通知方");
                condition.signal();
                Print.tco("发出通知了，但是线程还没立马释放锁");
            } finally {
                lock.unlock();
            }
        }
    };


}
