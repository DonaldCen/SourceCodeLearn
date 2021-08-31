package pattern.factory.method;

import pattern.factory.AliPay;
import pattern.factory.Pay;

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
