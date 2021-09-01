package com.learn.donald.aop.jdk;

import com.learn.donald.aop.ProxyCreator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/25 17:42
 * @Desc:
 */
public class JdkProxyCreator implements ProxyCreator, InvocationHandler {

    private Object target;

    public JdkProxyCreator(Object target){
        Class<?>[] interfaces = target.getClass().getInterfaces();
        if(interfaces.length == 0){
            throw new IllegalArgumentException("target class do not implement any interface");
        }
        this.target = target;
    }

    @Override
    public Object getProxy() {
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis() + "-" + method.getName() + "method start");
        Object result = method.invoke(target, args);
        System.out.println(System.currentTimeMillis() + "-" + method.getName() + "method over");
        return result;
    }
}
