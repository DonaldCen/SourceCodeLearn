package cn.donald.aop;

import cn.donald.aop.cglib.CglibProxyCreator;
import cn.donald.aop.cglib.Tank59;
import cn.donald.aop.cglib.TankInterceptor;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/26 15:30
 * @Desc:
 */
public class CglibProxyCreatorTest {

    public static void main(String[] args) {
        ProxyCreator proxyCreator = new CglibProxyCreator(new Tank59(),new TankInterceptor());
        Tank59 tank59 = (Tank59) proxyCreator.getProxy();
        System.out.println("proxy class = " + tank59.getClass() + "\n");
        tank59.run();
        System.out.println();
        System.out.print("射击测试：");
        tank59.shoot();
    }
}
