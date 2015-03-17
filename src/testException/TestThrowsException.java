package testException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试异常的抛出
 * Created by cashlu on 14/11/29.
 */
public class TestThrowsException {
    public static void main(String[] args) {
        /*
            由于openFile()方法将IOException和FileNotFoundException两个异常给抛出了。
            所以在创建对象并调用方法的时候，就必须捕获并处理这两个异常。

            这里其实还可以将异常再像上层抛出，不过不推荐这么做，因为上层没有代码处理这些异常。
         */
        try {
            String str = new TestThrowsException().openFile();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建对象时不用捕获对象成员方法的异常，只有在调用该方法是才需要捕获。
        TestThrowsException t = new TestThrowsException();
        try {
            t.openFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * openFile()方法不在内部捕获和处理两个异常，而是将异常抛出，异常由调用者来处理。
     *
     * @return 读取的字符串
     * @throws FileNotFoundException 其实这个异常不用抛出，因为他是IOException的子类，这里单独这么写，是为了表现抛出多个异常的语法
     * @throws IOException
     */
    String openFile() throws FileNotFoundException, IOException {
        File file = new File("/Users/cashlu/Desktop/test");
        FileReader reader = new FileReader(file);
        char c = (char) reader.read();
        //空字符串+char代表将char转型为字符串
        return "" + c;
    }
}


class Student{
    String name;
    int age;
    private Integer id;

    public Student(int age, Integer id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }
}



