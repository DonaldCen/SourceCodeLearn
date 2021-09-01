package com.learn.donald;

import com.learn.donald.other.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: DonaldCen
 * @Date: 2021/7/27 10:47
 * @Desc: TODO
 */
@Component
public class Test2 {
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    public String get(String a){
        String aaa = userService.hello(a, "hello world!"+a);
        System.out.println(aaa);
        return aaa;
    }

    public void test2() throws Exception{
        Class clazz = Class.forName("com.learn.donald.Test2");
        Object bean = applicationContext.getBean(clazz);
        Method method = clazz.getMethod("get", String.class);
        Object invoke = method.invoke(bean,"DonaldCen");
        System.out.println(JSON.toJSON(invoke));
    }

}
