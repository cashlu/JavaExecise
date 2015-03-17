package testCollection;

/**
 * 自己实现HashMap
 * Created by cashlu on 15/1/14.
 */
public class MyMapV1 {
    MyEntry[] arr = new MyEntry[100];
    int size;

    /**
     * 向map中添加新的键值对，如果key重复，覆盖value。
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        MyEntry item = new MyEntry(key, value);
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                arr[i].value = value;
                return;
            }
        }
        /*
            arr[size++] = item;
            可以写为：
            arr[size] = item;
            size++;
         */
        arr[size++] = item;

    }


    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i].value;
            }
        }
        return null;
    }

    public void remove(Object key) {
        MyEntry newArr[] = new MyEntry[200];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!arr[i].key.equals(key)) {
                newArr[j] = arr[i];
                j++;
            }
        }
        arr = newArr;
        this.size--;
    }

    /**
     * 判断map中的key是否存在指定的对象
     *
     * @param key 需要查找的key
     * @return 返回boolean值
     */
    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断map中的value是否存在指定的对象
     *
     * @param value 需要查找的value
     * @return 返回boolean值
     */
    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }


    public void printMap() {
        for (int i = 0; i < size; i++) {
            Object key = arr[i].key;
            System.out.println(key + " : " + this.get(key));
        }
    }

    public static void main(String[] args) {
        MyMapV1 map = new MyMapV1();
        map.put("Simon", new Wife("Jean"));
        map.put("Seven", new Wife("Eleven"));
        map.printMap();
        System.out.println("-------------");
        map.remove("Seven");
        map.printMap();

    }
}

class MyEntry {
    Object key;
    Object value;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}