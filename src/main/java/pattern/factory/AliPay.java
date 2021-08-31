package pattern.factory;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 15:47
 * @Desc: 支付宝
 */
public class AliPay implements Pay {
    @Override
    public void unifiedOrder() {
        System.out.println("支付宝支付..");
    }
}
