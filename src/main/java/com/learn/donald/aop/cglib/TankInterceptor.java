package com.learn.donald.aop.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/26 15:26
 * @Desc:
 */
public class TankInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if(method.getName().equals("run")){
            System.out.println("正在重造59坦克...");
            System.out.println("重造成功，已获取59改 之超音速飞行版");
            System.out.println("起飞！");
            Object o = proxy.invokeSuper(obj, args);
            System.out.println("啦啦啦啦");
            return null;
        }
        return proxy.invokeSuper(obj,args);
    }
}
