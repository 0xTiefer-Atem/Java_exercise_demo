package singleton;

/**
 * @Author WangQian
 * @Date 2020/10/4 下午 8:07
 */


/**
 * 利用枚举创造单例，不经可以解决线程同步还可以防止反射
 * 枚举类没有构造方法
 * */
public enum EnumSingleton {
    INSTANCE;
    public void m() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(EnumSingleton.INSTANCE.hashCode());
            }).start();
        }
    }
}
