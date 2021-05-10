package singleton;


//饿汉模式

/**
 * 类加载的 初始化阶段就完成了实例的初始化。本质上就是借助于jvm类加载机制，保证实例的唯一性
 * 类加载的过程:
 * 1 加载二进制数据到内存中，生成对应的Class数据结构
 * 2 连接：a.验证，b.准备（给类的静态成员变量赋值默认值），c.解析
 * 3 初始化: 给类的静态变量赋初值
 * 4 缺点: 不管用不用，类装载时都会完成实例化
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
