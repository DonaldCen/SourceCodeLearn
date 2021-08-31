package cn.donald.factorybean;

import lombok.Data;
import org.springframework.stereotype.Component;

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
