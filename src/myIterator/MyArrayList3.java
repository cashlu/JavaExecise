package myIterator;

import java.util.Iterator;

/**
 * 。
 * Created by cashlu on 15/2/2.
 */

//这里实现Iterator<T>接口，是为了main方法中使用foreach循环
public class MyArrayList3 implements java.lang.Iterable<String> {
    private String[] elem = {"A", "B", "C", "D", "E", "F", "G"};
    private int size = elem.length;


    //和之前的区别是，这里不再单独创建一个迭代器的类，因为只用了一次，所以用匿名内部类的方法实现。
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int cursor = -1;

            public boolean hasNext() {
                return cursor + 1 < size;
            }

            public String next() {
                cursor++;
                return elem[cursor];
            }

            /**
             * 这个remove()方法有bug，会抛出数组越界的异常。
             */
            public void remove() {
//                String[] temp = new String[elem.length - 1];
//                for (int i = 0; i < cursor; i++) {
//                    temp[i] = elem[i];
//                }
//                for (int i = cursor; i < elem.length; i++) {
//                    temp[i] = elem[i + 1];
//                }
//
//                elem = temp;

            }
        };
    }

    public static void main(String[] args) {
        MyArrayList3 list = new MyArrayList3();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }

        System.out.println();
        it = list.iterator();
        int count = 0;
        while (it.hasNext()) {
            count++;
            if (count == 2) {
                it.remove();
            }
            System.out.print(it.next() + "\t");


        }

        /*
        使用foreach，必须实现java.lang.Iterable<T>接口，并重写Iterator方法。
         */
        System.out.println();
        for (String e : list) {
            System.out.print(e + "\t");
        }
    }
}
