package singleton;


/**
 * 静态内部类单例
 * 1 本质上是利用类加载机制来保证线程安全
 * 2 只有在实际使用的时候，才会触发类的初始化，所以也是一种懒加载
 */

public class InnerClassSingleton {

    private InnerClassSingleton() {

    }
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                System.out.println(InnerClassSingleton.getInstance().hashCode());
            }).start();;
        }
    }
}
