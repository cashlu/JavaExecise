package testCollection;

import java.util.HashMap;

/**
 * 自己实现一个HashMap。
 * Created by cashlu on 15/1/29.
 */
public class MyHashSet {
    HashMap map;
    //创建一个空的对象，作为map的value
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    public void add(Object o) {
        map.put(o, PRESENT);
    }

    public void remove(Object o) {
        map.remove(o);
    }


    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add("Simon");
        set.add("Lo");
        set.add(new Human());
        System.out.println(set.size());
        set.remove("Lo");
        System.out.println(set.size());
    }

}
