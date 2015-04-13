package testio.testfile;

import java.io.File;

/**
 * 测试File对象的构造器方法
 * Created by cashlu on 15/4/13.
 */
public class TestConstructor {
    public static void main(String[] args) {
        File d = new File("/Users/cashlu/Desktop/");
        File f1 = new File("/Users/cashlu/Desktop/f1.txt");
        File f2 = new File("/Users/cashlu/Desktop", "f2.txt");
        File f3 = new File(d, "f3.txt");
        File f4 = new File("f4.txt");


        System.out.println(d);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

    }
}
