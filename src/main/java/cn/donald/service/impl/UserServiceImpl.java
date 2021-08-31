package cn.donald.service.impl;

import cn.donald.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
