package pattern.abstractFactory;

import pattern.factory.Pay;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:32
 * @Desc: 支付宝支付
 */
public class AliPay implements PayFactory {
    @Override
    public void unifiedOrder() {
        System.out.println("抽象工厂模式支付宝支付..");
    }
}
