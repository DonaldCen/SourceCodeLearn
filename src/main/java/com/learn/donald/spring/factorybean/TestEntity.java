package com.learn.donald.spring.factorybean;

import lombok.Data;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/31 18:23
 * @Desc:
 */
@Data
public class TestEntity {

    private String name;

    private String lg;

    public void test(){
        System.err.println("factory bean test..");
    }
}
