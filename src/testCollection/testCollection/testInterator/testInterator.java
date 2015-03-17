package testCollection.testCollection.testInterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试迭代器iterator的使用,Collection类的子类都包含iterator()方法的实现。
 * 因此List、Set、Map等类及其子类都包含迭代器方法。
 * Created by cashlu on 15/1/30.
 */
public class testInterator {
    public static void main(String[] args) {
        Set set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        //创建迭代器对象
        Iterator iter = set.iterator();
        //遍历迭代器
        while (iter.hasNext()) {
            int i = (Integer) iter.next();
            System.out.print(i + "\t");
        }

        //for循环来迭代
        System.out.println();
        for (Iterator ite = set.iterator(); ite.hasNext();){
            System.out.print(ite.next() + "\t");
        }
    }
}
