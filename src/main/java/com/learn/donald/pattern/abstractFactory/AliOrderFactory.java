package com.learn.donald.pattern.abstractFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:30
 * @Desc: 阿里订单工厂
 */
public class AliOrderFactory implements OrderFactory{
    @Override
    public PayFactory createPay() {
        return new AliPay();
    }

    @Override
    public RefundFactory createRefund() {
        return new AliRefund();
    }
}
