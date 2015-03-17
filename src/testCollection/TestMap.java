package testCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的基本使用方法
 * Created by cashlu on 15/1/14.
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        Map newMap = new HashMap();

        Wife jean = new Wife("Jean");
        Wife eleven = new Wife("Eleven");

        map.put("Simon", jean);
        map.put("Seven", eleven);
        newMap.put("张三", new Wife("王五"));
        map.putAll(newMap);
        newMap.clear();

        newMap.put("Simon", "Lo");
        newMap.put(11, 22);


//        Wife w = (Wife)map.get("Seven");
        //HaskMap的get方法，返回的是一个Object对象，需要强制类型转换
        System.out.println(((Wife) map.get("Simon")).name);
        System.out.println(((Wife)map.get("Seven")).name);
        System.out.println(map.size());
//        map.remove("Simon");
        System.out.println(map.containsKey("Simon"));
        System.out.println(map.containsKey("Seven"));
        System.out.println(map.containsValue(jean));
        System.out.println(map.containsValue(eleven));

        System.out.println(newMap.get("Simon"));
        System.out.println(newMap.get(11));
    }
}


class Wife{
    String name;
    public Wife(String name) {
        this.name = name;
    }
}