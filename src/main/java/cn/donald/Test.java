package cn.donald;

import cn.donald.aware.TestAware;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
