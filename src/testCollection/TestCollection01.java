package testCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ArrayList类的基本操作
 * Created by cashlu on 14/12/25.
 */
public class TestCollection01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list2 = new ArrayList();
        list.add("Cash");
        list.add(new Date());
        list.add(1234);

        list2.add(999);
        list2.add("Lo");

        //将list2中的元素添加到list中
        list.add(list2);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).hashCode());
        }
        //这里的new Date()明显和之前不是同一个对象，为什么能删除成功？
        list.remove(new Date());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).hashCode());
        }

    }

}
