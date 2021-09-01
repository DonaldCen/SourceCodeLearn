package com.learn.donald.service.impl;

import com.learn.donald.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @Author: DonaldCen
 * @Date: 2021/7/26 20:02
 * @Desc: UserServiceImpl
 */
@Component
public class UserServiceImpl implements UserService {

    public String hello(String a, String b) {
        System.out.println("hello 鸭~");
        return a +","+ b;
    }
}
