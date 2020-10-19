import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("张三","20");
        map.put("李四","20");
        map.put("王五","21");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("========");
        System.out.println(map.get("张三"));
        System.out.println(map.getOrDefault("赵六","50"));
        System.out.println("========");
        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsValue("21"));
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
