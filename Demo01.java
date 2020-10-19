import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo01 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("我");
        list.add("爱");
        list.add("java");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        //返回一个装有集合元素的数组
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        for(String s : list) {
            System.out.println(s);
        }
        list.remove("我");
        list.clear();
    }
}
