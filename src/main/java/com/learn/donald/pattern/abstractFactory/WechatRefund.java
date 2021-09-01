package com.learn.donald.pattern.abstractFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:41
 * @Desc: 微信退款
 */
public class WechatRefund implements RefundFactory{
    @Override
    public void refund() {
        System.out.println("抽象工厂方法：微信退款...");
    }
}
