package strategy;

/**
 * @Author WangQian
 * @Date 2020/10/4 下午 8:17
 */
public class Cat {
    private int weight;
    private int height;
    public Cat(int weight, int height) {
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Cat c) {
        if(this.weight < c.weight) {
            return -1;
        }else if(this.weight > c.weight) {
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
