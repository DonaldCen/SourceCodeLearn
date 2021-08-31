package pattern;

import pattern.abstractFactory.FactoryProducer;
import pattern.abstractFactory.OrderFactory;
import pattern.factory.Pay;
import pattern.factory.method.AliPayFactory;
import pattern.factory.method.PayFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 15:51
 * @Desc:
 */
public class TestMain {
    public static void main(String[] args) {

        OrderFactory factory = FactoryProducer.getFactory("wechat");
        factory.createPay().unifiedOrder();
        factory.createRefund().refund();
    }
}
