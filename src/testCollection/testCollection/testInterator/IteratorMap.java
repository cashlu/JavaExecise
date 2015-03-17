package testCollection.testCollection.testInterator;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by cashlu on 15/1/31.
 */
public class IteratorMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        Set keys = map.keySet();

        /*
        第一种迭代Map的方法，先迭代key，然后通过key找value。
        因为需要多次根据key找value，所以效率有可能稍差。
         */
        for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            String value = (String) map.get(key);
        }

        /*
        第二种迭代Map的方法，迭代Map的Entry(以键值对为单位)，然后分别遍历每一个Entry。
        比起第一种方法，在大部分情况下，效率会高一些。
         */
        for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
            Entry e = (Entry) iter.next();
            String key = (String) e.getKey();
            String value = (String) e.getValue();

        }
    }
}
