package com.learn.donald.lock.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: DonaldCen
 * @Date: 2021/10/19 11:52
 * @Desc:
 */
@Slf4j
public class FutureTaskTest {
    public static final int SLEEP_GAP = 5000;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static Callable<Boolean> hotWaterJob = new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("放在火上");
                Thread.sleep(SLEEP_GAP);
                log.info("水开了");
            } catch (InterruptedException e) {
                log.info("发生异常被中断");
                return false;
            }
            log.info("运行结束");
            return true;
        }
    };

    static Callable<Boolean> washJob = new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗茶壶");
                log.info("洗茶杯");
                log.info("拿茶叶");
                Thread.sleep(SLEEP_GAP);
                log.info("洗完了");
            } catch (InterruptedException e) {
                log.info("发生异常被中断");
                return false;
            }
            log.info("清洗工作 运行结束");
            return true;
        }
    };

    public static void drinkTea(boolean waterOk, boolean cupOk) {
        if (waterOk && cupOk) {
            log.info("泡茶喝");
        } else if (!waterOk) {
            log.info("烧水失败，没有茶喝了");
        } else if (!cupOk) {
            log.info("杯子洗不了，没有茶喝了");
        } else {
            log.info("烧水失败，杯子也洗不了");
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        FutureTask<Boolean> hotWaterTask = new FutureTask<>(hotWaterJob);
        Thread h = new Thread(hotWaterTask,"** 烧水-Thread");

        FutureTask<Boolean> washTask = new FutureTask<>(washJob);
        Thread w = new Thread(washTask, "** 清洗-Thread");

        h.start();
        w.start();

        try {
            Boolean waterOk = hotWaterTask.get();
            Boolean cupOk = washTask.get();
            drinkTea(waterOk,cupOk);
        } catch (InterruptedException e) {
            log.info(getCurThreadName() + "发生中断异常被中断");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info(getCurThreadName() + "运行结束。");
    }
}
