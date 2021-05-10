import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Test {
    public static void main(String[] args) {
        ConcurrentMap<String,String> myMap = new ConcurrentHashMap<>();
        myMap.put("qwe","qwe");
        myMap.put("asd","asd");
        System.out.println(myMap.size());
        myMap.remove("qwe");
        System.out.println(myMap.size());
    }
}
