package testCollection;

/**
 * 自己实现一个ArrayList类的功能
 * Created by cashlu on 14/12/26.
 */
public class MyArrayList {
    private Object elementDate[];
    //size的初始值是0
    private int size;


    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapcity) {
        if (initialCapcity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementDate = new Object[initialCapcity];
    }

    public void ensureCapacity() {
        /*
            数组空间的扩容，用以保证数组的空间不会被放满。
            思路是创建一个新的临时数组，大小是原数组的2倍，将原数组的元素拷贝进去，然后再将原数组指向新数组的对象。
         */
        if (size >= elementDate.length) {
            Object newArray[] = new Object[size * 2];
            System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
            elementDate = newArray;
        }

    }

    /**
     * 确保数组的最后一个元素不是null。主要用来服务于remove()方法，因为remove()方法操作后，
     * 被删除元素以后的所有元素都会向前移位，并将最后一个元素置为null，null依旧会占用一个位置，
     * 所以这个方法的作用是创建一个短一位的新数组，将老数组除了最后一个元素外全部拷贝过来，
     * 然后将老数组的引用指向新数组，并且将size的值减少1。
     */
    public void ensureNoNull() {
        if (elementDate[size - 1] == null) {
            Object newElementDate[] = new Object[size - 1];
            System.arraycopy(elementDate, 0, newElementDate, 0, size - 1);
            elementDate = newElementDate;
            size--;
        }
    }

    /**
     * 增加元素，将新元素追加到数组的最后一个位置。
     *
     * @param obj
     */
    public void add(Object obj) {
        ensureCapacity();

        /*  先赋值，后增加，相当于如下代码：
            elementDate[size] = obj;
            size++;
         */
        elementDate[size++] = obj;
    }

    public void add(int index, Object obj) {
        rangeCheck(index);
        if (index == size - 1) {
            add(obj);
        } else {
            ensureCapacity();
            System.arraycopy(elementDate, index, elementDate, index + 1, size - index);
            elementDate[index] = obj;
        }
    }

    /**
     * 判断容器是否为空
     *
     * @return 返回一个布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 该方法用于判断其他方法操作数组时，传入的index参数是否越界。
     *
     * @param index 数组下标
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }


    private Object get(int index) {
        rangeCheck(index);
        return elementDate[index];
    }

    public String getAll() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += (elementDate[i] + "\t");
        }
        return res;
    }

    public void remove(int index) {
        rangeCheck(index);

        //numMoved代表要向前移动的元素的个数
        int numMoved;
        if (index == size - 1) {
            numMoved = 1;
        } else {
            numMoved = size - index - 1;
        }
        if (numMoved > 0) {
            //将要删除元素以后的元素，全部拷贝至原数组中，但是拷贝的位置向前移动一位，覆盖掉需要删除的那个元素。
            System.arraycopy(elementDate, index + 1, elementDate, index, numMoved);
            //拷贝后，最后一个元素是重复的，所以要把最后一个元素赋值为Null。
            elementDate[size - 1] = null;
        }
        ensureNoNull();
    }

    public void remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                remove(i);
            }
        }
    }


    /**
     * 替换某一索引位置的值
     *
     * @param index 要替换的索引位置
     * @param obj   要替换的新对象
     * @return 返回替换之前的老值
     */
    public Object set(int index, Object obj) {
        rangeCheck(index);
        Object oldValue = elementDate[index];
        elementDate[index] = obj;
        return oldValue;
    }


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list.size);
        System.out.println(list.isEmpty());

        list.remove(2);
        System.out.println(list.getAll());

        list.add("Simon");
        System.out.println(list.getAll());

        list.remove("Simon");
        System.out.println(list.getAll());

        list.set(18, "十九");
        System.out.println(list.getAll());

        list.add("二十");
        System.out.println(list.getAll());

    }
}
