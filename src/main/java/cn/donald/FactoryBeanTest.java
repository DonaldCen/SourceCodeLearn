package cn.donald;

import cn.donald.factorybean.ScanConfig;
import cn.donald.factorybean.TestEntity;
import cn.donald.factorybean.TestEntityFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
