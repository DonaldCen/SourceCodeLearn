package com.learn.donald.utils;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/27 16:09
 * @Desc:
 */
public class Print {

    public static void tco(Object s){
        String cft = "[" + Thread.currentThread().getName() + "]"+": "+s;
        ThreadUtil.execute(() -> {
           synchronized (System.out){
               System.out.println(cft);
           }
        });
    }
}
