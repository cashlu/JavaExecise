package myIterator;

/**
 * 自己实现一个简单的迭代器,主要实现hasNext()、next()、remove()三个方法。
 * Created by cashlu on 15/2/2.
 */
public class MyArrayList {
    private String[] elem = {"A", "B", "C", "D", "E", "F", "G"};
    private int size = elem.length;
    //游标的初始值为-1，是因为数组的第一个下标是0。
    private int cursor = -1;


    public boolean hasNext() {
        return cursor + 1 < size;
    }

    public String next() {
        cursor++;
        return elem[cursor];
    }

    public void remove() {
        String[] temp = new String[elem.length - 1];
        for (int i = 0; i < cursor; i++) {
            temp[i] = elem[i];
        }
        for (int i = cursor; i < elem.length; i++) {
            temp[i] = elem[i + 1];
        }

        elem = temp;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        while (list.hasNext()){
            System.out.print(list.next() + "\t");
        }

        list = new MyArrayList();
        while (list.hasNext()){
            System.out.print(list.next() + "\t");
        }
    }

}
