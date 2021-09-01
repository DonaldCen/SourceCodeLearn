package com.learn.donald.pattern.Singleton;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 14:24
 * @Desc: 单例设计模式-饿汉方式
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry(){}

    public static SingletonHungry getInstance(){
        return instance;
    }

}
