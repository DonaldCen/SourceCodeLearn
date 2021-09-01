package com.learn.donald;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: DonaldCen
 * @Date: 2021/7/27 11:08
 * @Desc: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeneratorApp.class)
public class Test3 {
    @Autowired
    private Test2 test2;

    @Test
    public void test1() throws Exception {
        test2.test2();
    }
}
