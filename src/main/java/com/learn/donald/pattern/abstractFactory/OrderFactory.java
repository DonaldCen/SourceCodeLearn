package com.learn.donald.pattern.abstractFactory;


/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:27
 * @Desc: 订单抽象工厂
 */
public interface OrderFactory {

    PayFactory createPay();

    RefundFactory createRefund();
}
