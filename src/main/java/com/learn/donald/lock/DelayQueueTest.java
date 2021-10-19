package com.learn.donald.lock;

import com.learn.donald.lock.delay.DelayQueueItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: DonaldCen
 * @Date: 2021/10/15 14:05
 * @Desc:
 */
public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueueItem item1 = new DelayQueueItem("item1", 5, TimeUnit.SECONDS);
        DelayQueueItem item2 = new DelayQueueItem("item2",10, TimeUnit.SECONDS);
        DelayQueueItem item3 = new DelayQueueItem("item3",15, TimeUnit.SECONDS);
        DelayQueue<DelayQueueItem> queue = new DelayQueue<>();
        queue.put(item1);
        queue.put(item2);
        queue.put(item3);
        System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        for (int i = 0; i < 3; i++) {
            DelayQueueItem take = queue.take();
            System.out.format("name:{%s}, time:{%s}\n",take.getName(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }
    }
}
