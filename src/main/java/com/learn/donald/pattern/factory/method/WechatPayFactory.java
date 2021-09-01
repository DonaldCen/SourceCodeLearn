package com.learn.donald.pattern.factory.method;

import com.learn.donald.pattern.factory.Pay;
import com.learn.donald.pattern.factory.WechatPay;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:07
 * @Desc:
 */
public class WechatPayFactory implements PayFactory{
    @Override
    public Pay getPay() {
        return new WechatPay();
    }
}
