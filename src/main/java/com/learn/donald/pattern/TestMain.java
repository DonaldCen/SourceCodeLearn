package com.learn.donald.pattern;

import com.learn.donald.pattern.abstractFactory.FactoryProducer;
import com.learn.donald.pattern.abstractFactory.OrderFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 15:51
 * @Desc:
 */
public class TestMain {
    public static void main(String[] args) {

        OrderFactory factory = FactoryProducer.getFactory("wechat");
        factory.createPay().unifiedOrder();
        factory.createRefund().refund();
    }
}
