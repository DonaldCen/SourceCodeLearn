package com.learn.donald;

import com.learn.donald.aware.TestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: DonaldCen
 * @Date: 2021/7/26 19:58
 * @Desc: TODO
 */
@Component
public class Test {

    @Autowired
    private Test2 test2;
    @Autowired
    private TestAware testAware;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context.xml");
        Object aa = applicationContext.getBean("aa");
        TestAware testAware = applicationContext.getBean("testAware", TestAware.class);
        testAware.test();

    }





}
