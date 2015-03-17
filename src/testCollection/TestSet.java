package testCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试set的常用方法。
 * HashSet底层是由HashMap来实现的,hashMap具有Key唯一的特性，set利用了这个特性。
 * Created by cashlu on 15/1/19.
 */
public class TestSet {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("aaa");
        set.add("BBB");
        set.add("aaa");
        System.out.println(set.size());     //输出为2，因为两个"aaa"的equals为true。（参考HashMap中key不能重复的实现机制）
        System.out.println(set.contains("aaa"));
        set.remove("BBB");

    }
}
