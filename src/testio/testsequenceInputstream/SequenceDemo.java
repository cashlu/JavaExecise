package testio.testsequenceInputstream;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 测试SequenceInputStream(合并流)的使用。
 * 合并流的作用是将多个源封装进一个集合，作为统一的输入流，写入输出流中。
 * 本例中是将三个文本文件封装进集合，合并输出到一个目标文本文件中。
 * 可用于多个文件的合并。
 *
 * SequenceInputStream要求传入的参数是一个可枚举的集合对象，这里用到了Vector。
 * Created by cashlu on 15/4/24.
 */
public class SequenceDemo {
    public static void main(String[] args) {
        Vector<FileInputStream> v = new Vector<FileInputStream>();
        try {
            v.add(new FileInputStream("/Users/cashlu/Desktop/1.txt"));
            v.add(new FileInputStream("/Users/cashlu/Desktop/2.txt"));
            v.add(new FileInputStream("/Users/cashlu/Desktop/3.txt"));

            Enumeration<FileInputStream> en = v.elements();
            SequenceInputStream sis = new SequenceInputStream(en);
            FileOutputStream fos = new FileOutputStream("/Users/cashlu/Desktop/4.txt");


            byte[] buff = new byte[sis.available()];
            int len = 0;
            while ((len = sis.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
