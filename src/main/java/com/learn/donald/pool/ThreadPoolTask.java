package com.learn.donald.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/22 11:23
 * @Desc:
 */
@Slf4j
@Component
public class ThreadPoolTask {

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    public void add(List<String> msgList){
        if(!CollectionUtils.isEmpty(msgList)){
            for (String s : msgList) {
                queue.offer(s);
            }
        }
    }

    @PostConstruct
    private void init(){
        executorService.submit(testTaskWorker);
    }

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    private Runnable testTaskWorker = new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setName("test-Task-Worker");
            while (true){
                try {
                    String msg = queue.take();
                    log.info(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
