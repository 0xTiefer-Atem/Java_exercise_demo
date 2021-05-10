package strategy;

/**
 * @Author WangQian
 * @Date 2020/10/4 下午 8:18
 */
public class Sorter {
    public static void sort(Cat[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos] ) == -1  ? j : minPos;
            }
            swap(arr,i, minPos);
        }
    }

    static void swap(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
