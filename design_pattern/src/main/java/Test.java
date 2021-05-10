import singleton.LazySingleton;

public class Test {
    public static void main(String[] args) {
//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println(instance == instance1);
        new Thread(() -> {
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();
        new Thread(() -> {
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();
    }
}
