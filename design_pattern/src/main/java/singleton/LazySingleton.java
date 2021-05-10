package singleton;


/**
 * 懒汉模式
 * 保证一个类只有一个实例，并且提供一个全局访问点
 * 场景: 重量级的对象，不需要多个实例，如线程池，数据库连接池
 */


/**
 * 懒汉模式：延迟加载，只有在真正使用的时候，才初始化
 * 1)线程安全问题
 * 2)double check锁优化
 * 3)编译器(jit),cpu有可能对指令进行重排，导致使用到尚未初始化的实例，可以通过添加volatile关键字进行修饰，对于
 * volatile修饰的字段，可以防止指令重排
 */
public class LazySingleton {
    //volatile关键字: 防止指令重排，增强变量的可见性
    private volatile static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        //这次判断是为了节省效率
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                    //字节码层面
                    //JIT编译时期会进行指令重拍
                    //1.开辟空间
                    //2.初始化
                    //3.引用赋值

                }
            }
        }
        return instance;
    }
}
