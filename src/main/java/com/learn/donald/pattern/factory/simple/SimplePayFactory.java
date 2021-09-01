package com.learn.donald.pattern.factory.simple;

import org.springframework.util.StringUtils;
import com.learn.donald.pattern.factory.AliPay;
import com.learn.donald.pattern.factory.Pay;
import com.learn.donald.pattern.factory.WechatPay;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 15:48
 * @Desc:
 */
public class SimplePayFactory {

    /**
     * 根据参数，返回对应的参数
     * @param payType
     * @return
     */
    public static Pay createPay(String payType){
        if(StringUtils.isEmpty(payType)){
            return null;
        }
        if(payType.equalsIgnoreCase("wechat")){
            return new WechatPay();
        }
        if(payType.equalsIgnoreCase("ali")){
            return new AliPay();
        }
        return null;
    }
}
