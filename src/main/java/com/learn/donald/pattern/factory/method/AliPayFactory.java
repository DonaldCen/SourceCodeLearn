package com.learn.donald.pattern.factory.method;

import com.learn.donald.pattern.factory.AliPay;
import com.learn.donald.pattern.factory.Pay;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:06
 * @Desc:
 */
public class AliPayFactory implements PayFactory{
    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
