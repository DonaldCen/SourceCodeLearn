package com.learn.donald.pool;

import com.learn.donald.spring.factorybean.ScanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/22 11:32
 * @Desc:
 */
public class TaskTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
        List<String> msgList = Arrays.asList("addd","b","c");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ScanConfig.class);
        ThreadPoolTask bean = ac.getBean(ThreadPoolTask.class);
        bean.add(msgList);
        /*System.out.println(COUNT_BITS);
        System.out.println("CAPACITY:"+Integer.toBinaryString(CAPACITY));
        System.out.println("RUNNING:"+Integer.toBinaryString(RUNNING));
        System.out.println("SHUTDOWN:"+Integer.toBinaryString(SHUTDOWN));
        System.out.println("STOP:"+Integer.toBinaryString(STOP));
        System.out.println("TIDYING:"+Integer.toBinaryString(TIDYING));
        System.out.println("TERMINATED:"+Integer.toBinaryString(TERMINATED));

        System.out.println(Integer.toBinaryString(runStateOf(RUNNING)));*/
    }

    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
}
