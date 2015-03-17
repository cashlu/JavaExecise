package testCollection;

import java.util.LinkedList;

/**
 * 自己实现Map的升级版，采用数组+链表的方式来存储，hashCode冲突的元素，放置在链表中。
 * 1、提升查询效率
 * Created by cashlu on 15/1/15.
 */
public class MyMap {
    LinkedList[] arr = new LinkedList[999];
    int size;

    public void put(Object key, Object value){
        MyEntry entry = new MyEntry(key, value);
        int id = key.hashCode() % arr.length;
        if (arr[id] == null){
            LinkedList list = new LinkedList();
            arr[id] = list;
            list.add(entry);
        }else {
            LinkedList list = arr[id];
            //for循环是遍历链表，如果key重复，则覆盖value。
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry2 = (MyEntry)list.get(i);
                if (entry2.key.equals(key)){
                    entry2.value = value;
                    return;
                }
            }
            //如果不重复，则直接在链表中添加MyEntry对象。
            arr[id].add(entry);
        }
//        size++;
    }

    /**
     * 获取特定key的value。
     * 先通过hashCode的计算，判断数组元素是否是链表，如果是链表，说明hashCode取余有重码，那么遍历链表，找到需要的Node。
     * @param key 要获取value的键值对的key
     * @return 返回键值对的value
     */
    public Object get(Object key){
        int id = key.hashCode() % arr.length;
        if (arr[id] != null){
            LinkedList list = arr[id];
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry = (MyEntry)list.get(i);
                if (entry.key.equals(key)){
                    return entry.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyMap map = new MyMap();
        map.put("Simon", new Wife("Jean"));
        map.put("Simon", new Wife("Lily"));
        Wife w = (Wife)map.get("Simon" );
        System.out.println(w.name);
    }
}
