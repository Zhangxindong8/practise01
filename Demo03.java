import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("c语言");
        list.add("java");
        list.add("c++");
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(1,"c#");
        //截取
        List<String> subList = list.subList(1, 2);
        //重新构造
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
