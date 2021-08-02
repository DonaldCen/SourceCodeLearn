package cn.donald.service.impl;

import cn.donald.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: DonaldCen
 * @Date: 2021/7/26 20:02
 * @Desc: UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    public String hello(String a, String b) {
        return a +","+ b;
    }
}
