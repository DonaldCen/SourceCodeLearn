package com.learn.donald.aop;

import com.learn.donald.aop.jdk.JdkProxyCreator;
import com.learn.donald.service.UserService;
import com.learn.donald.service.impl.UserServiceImpl;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/25 17:48
 * @Desc:
 */
public class JdkProxyCreatorTest {
    public static void main(String[] args) {
        ProxyCreator proxyCreator = new JdkProxyCreator(new UserServiceImpl());
        UserService userService = (UserService) proxyCreator.getProxy();
        System.out.println("proxy type = " + userService.getClass());
        System.out.println();
        System.out.println(userService.hello("hello","world"));
        System.out.println();
    }
}
