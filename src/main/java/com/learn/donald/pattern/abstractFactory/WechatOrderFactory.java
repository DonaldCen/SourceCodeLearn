package com.learn.donald.pattern.abstractFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:36
 * @Desc: 微信下单工厂
 */
public class WechatOrderFactory implements OrderFactory{
    @Override
    public PayFactory createPay() {
        return new WechatPay();
    }

    @Override
    public RefundFactory createRefund() {
        return new WechatRefund();
    }
}
