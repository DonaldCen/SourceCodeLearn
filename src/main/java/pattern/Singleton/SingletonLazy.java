package pattern.Singleton;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/30 11:41
 * @Desc: 单例模式-懒汉模式
 */
public class SingletonLazy {

    private SingletonLazy(){}

    private static volatile SingletonLazy instance;

    public void process(){
        System.out.println("方法调用成功..");
    }

    /**
     * 第一种方法
     * 线程不安全，多线程下存在安全问题
     */
    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return getInstance();
    }

    /**
     * 通过加锁 synchronized 保证单例
     * 高并发情况下，采用 synchronized 对方法加锁有很大的性能开销
     * 解决方法：锁粒度不要那么大
     */
    public static synchronized SingletonLazy getInstance1(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return getInstance();
    }

    /**
     * 第三种实现方式
     * 减少 synchronized的颗粒度
     * 但是 多线程还是有问题，需要 double check locking机制(DCL),多线程下保持高性能
     * 这个是否安全？
     * instance = new SingletonLazy(); 这一句并不是原子性（JMM的知识）
     * 1. 分配空间给对象
     * 2. 在空间内创建对象
     * 3. 将对象赋值给引用instance
     * 解决方案：volatile
     */
    public static SingletonLazy getInstance2(){
        if(instance == null){
            synchronized (SingletonLazy.class){
                instance = new SingletonLazy();
            }
        }
        return getInstance();
    }
}
