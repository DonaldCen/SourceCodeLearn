package pattern.factory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 15:47
 * @Desc: 微信支付
 */
public class WechatPay implements Pay {
    @Override
    public void unifiedOrder() {
        System.out.println("微信支付..");
    }
}
