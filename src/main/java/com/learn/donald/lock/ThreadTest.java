package com.learn.donald.lock;

import com.learn.donald.utils.Print;
import com.learn.donald.utils.ThreadUtil;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/27 17:25
 * @Desc:
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                Print.tco("线程启动了");
                while (true){
                    boolean flag = ThreadUtil.isInterrupted();
                    Print.tco(flag);
                    if(flag){
                        Print.tco("线程结束了");
                        return;
                    }
                }
            }
        };
        thread.start();
        ThreadUtil.sleepMilliSeconds(100);
        thread.interrupt();
        ThreadUtil.sleepMilliSeconds(5);
        thread.interrupt();

    }
}
