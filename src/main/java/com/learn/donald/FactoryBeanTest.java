package com.learn.donald;

import com.learn.donald.spring.factorybean.ScanConfig;
import com.learn.donald.spring.factorybean.TestEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/31 17:53
 * @Desc:
 */
public class FactoryBeanTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ScanConfig.class);
        TestEntity testEntity = (TestEntity) ac.getBean("testEntityFactoryBean");
        testEntity.test();

    }
}
