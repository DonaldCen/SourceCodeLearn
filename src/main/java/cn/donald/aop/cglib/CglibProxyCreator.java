package cn.donald.aop.cglib;

import cn.donald.aop.ProxyCreator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/26 15:21
 * @Desc:
 */
public class CglibProxyCreator implements ProxyCreator {
    private Object target;

    private MethodInterceptor methodInterceptor;

    public CglibProxyCreator(Object object,MethodInterceptor methodInterceptor){
        this.target = object;
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }
}
