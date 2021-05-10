package strategy;

import java.util.Arrays;

/**
 * @Author WangQian
 * @Date 2020/10/4 下午 8:17
 */

/**
 * 策略模式
 */
public class Main {
    static ThreadLocal<String> tl = new ThreadLocal<>();
    public static void main(String[] args) {
//        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] a = {new Cat(3,3), new Cat(1,1),new Cat(2,2)};
        Sorter.sort(a);
        System.out.println(Arrays.toString(a));
        tl.get();
        tl.remove();
    }
}
