package myIterator;

import java.util.Iterator;

/**
 * 自己实现迭代器，加入接口。使用接口的好处是，如果没有接口，如果希望再次遍历容器，
 * 因为cursor已经到了最大值，所以需要再new一个容器对象，开销大。
 * 如果有接口，只需要new一个迭代器对象，开销小。
 * Created by cashlu on 15/2/2.
 */
public class MyArrayList2 {
    private String[] elem = {"A", "B", "C", "D", "E", "F", "G"};
    private int size = elem.length;


    private class MyIt implements Iterator<String> {
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
    }

    public Iterator<String> iterator(){
        return new MyIt();
    }

    public static void main(String[] args) {
        MyArrayList2 list = new MyArrayList2();
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + "\t");
        }

        it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + "\t");
        }
    }
}
