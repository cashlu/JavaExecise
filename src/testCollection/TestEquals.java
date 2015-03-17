package testCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cashlu on 15/1/16.
 */
public class TestEquals {
    public static void main(String[] args) {
        List list = new ArrayList();
        String s1 = "aaa";
        String s2 = "aaa";
        list.add(s1);
        list.add(s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(list.size());
        System.out.println(list.get(0).equals(list.get(1)));
        System.out.println(s1 == s2);


        /*
            用HashMap来测试equals()方法
            HashMap中的Key不能重复，而s1和s2是String对象，s1 == s2, s1.equals(s2) = true。
            所以在HashMap中，s1和s2是两个相同的key，s2的value覆盖了s1的value。
         */
        Map m = new HashMap();
        m.put(s1, "aaaa");
        m.put(s2, "bbbb");
        System.out.println(m.get(s1));
    }
}
