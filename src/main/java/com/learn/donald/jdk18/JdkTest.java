package com.learn.donald.jdk18;

import java.util.function.Function;

/**
 * @Author: DonaldCen
 * @Date: 2021/10/19 18:02
 * @Desc:
 */
public class JdkTest {


    public static <T> int square(T t){
        return 100 + t.hashCode();
    }


}
