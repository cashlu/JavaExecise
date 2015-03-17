package testMyArrayList;

/**
 * 通过数组模拟JDK中ArrayList类的功能。
 * Created by cashlu on 14/11/18.
 */
public class MyArrayList {

    private Object value[];
    private int size;

    public int getSize() {
        return this.size;
    }

    public MyArrayList() {
//        value = new Object[16];

        //一个构造器调用另一个构造器，相当于是调用了下方重载的那个构造器
        this(16);
    }

    //重载了构造器函数
    public MyArrayList(int size) {
        if (size < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        value = new Object[size];
    }

    //向自建容器内添加元素
    public void add(Object object) {
        value[size] = object;
        size++;

        /**
         * 数组扩容
         * 因为MyArrayList对象的初始长度是16，如果增加元素超过16个，会抛出下标溢出的异常。
         * 创建一个新的MyArrayList对象，长度是原来的两倍，并将原数组的元素copy过来，然后将原数组指向新数组。
         */
        if (size >= value.length) {
            int newCapacity = value.length * 2;
            Object newList[] = new Object[newCapacity];

            for (int i = 0; i < value.length; i++) {
                newList[i] = value[i];
            }
            value = newList;
        }
    }

    //从自建容器中提取元素
    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value[index];
    }

    //返回元素在数组内的下标
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        } else {
            for (int i = 0; i < value.length; i++) {
                if (obj == value[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList();
        mal.add("Hey");
        mal.add("nice");
        mal.add('c');
        mal.add(56);

        Human p1 = new Human("Simon");
        mal.add(p1);

        for (int i = 0; i <= 100; i++) {
            mal.add(i);
        }

        for (int i = 0; i < mal.getSize(); i++) {
            System.out.println(mal.get(i));
        }

        System.out.println(mal.indexOf('c'));
    }

}
