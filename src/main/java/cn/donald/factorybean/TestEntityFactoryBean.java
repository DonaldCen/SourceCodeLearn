package cn.donald.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/31 18:21
 * @Desc:
 */
@Component
public class TestEntityFactoryBean implements FactoryBean<TestEntity> {
    @Override
    public TestEntity getObject() throws Exception {
        return new TestEntity();
    }

    @Override
    public Class<?> getObjectType() {
        return TestEntity.class;
    }
}
