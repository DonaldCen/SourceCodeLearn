package cn.donald.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/23 15:58
 * @Desc:
 */
@Component
public class TestAware implements BeanFactoryAware {

    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void test(){
        boolean isContainBean = beanFactory.containsBean("aa");
        if(isContainBean){
            System.out.println("包含aa这个类");
        }else{
            System.out.println("不包含aa这个类");
        }
    }
}
