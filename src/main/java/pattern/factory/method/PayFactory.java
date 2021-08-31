package pattern.factory.method;

import pattern.factory.Pay;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 16:05
 * @Desc: 抽象工厂方法
 */
public interface PayFactory {
    Pay getPay();
}
