package pattern.factory.method;

import pattern.factory.Pay;
import pattern.factory.WechatPay;

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
