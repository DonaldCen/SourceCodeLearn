package com.learn.donald.pattern.abstractFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:38
 * @Desc: 支付宝退款
 */
public class AliRefund implements RefundFactory{
    @Override
    public void refund() {
        System.out.println("抽象工厂：支付宝退款..");
    }
}
