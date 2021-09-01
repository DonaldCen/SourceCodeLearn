package com.learn.donald.pattern.abstractFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:43
 * @Desc: 工厂生产者
 */
public class FactoryProducer {

    public static OrderFactory getFactory(String type){
        if(type.equalsIgnoreCase("wechat")){
            return new WechatOrderFactory();
        }
        if(type.equalsIgnoreCase("ali")){
            return new AliOrderFactory();
        }
        return null;
    }
}
