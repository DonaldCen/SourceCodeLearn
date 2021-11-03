package com.learn.donald.jdk18;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * @Author: DonaldCen
 * @Date: 2021/10/19 18:02
 * @Desc:
 */
public class JdkTest {


    public static void main(String[] args) {
        /*String a = "aaa";
        String a1 = "aaa";
        System.out.println(a==a1);

        String b = new String("bbb");
        String b1 = new String("bbb");
        System.out.println(b==b1);

        String c = new String("bbb");
        String c1 = new String("bbb");
        String c2 = c1.intern();
        System.out.println(c==c1);
        System.out.println(c==c2);*/
        ArrayList<Integer> a1 = new ArrayList<>(1);
        a1.add(9);
        a1.add(6);
        a1.add(5);
        a1.add(3);
        a1.add(8);
        a1.add(2,9);

    }


}
