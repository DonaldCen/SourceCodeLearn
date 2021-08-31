package pattern.abstractFactory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:37
 * @Desc: 微信支付
 */
public class WechatPay implements PayFactory{
    @Override
    public void unifiedOrder() {
        System.out.println("抽象工厂方法：微信支付..");
    }
}
