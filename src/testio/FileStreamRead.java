package testio;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节流读写文件的方法
 * Created by cashlu on 15/4/2.
 */
public class FileStreamRead {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileInputStream对象的read()方法的JDK说明如下：
     * Reads up to buf.length() bytes of data from this input stream into an array of bytes.
     * This method blocks until some input is available.
     * 简单的说，就是读取参数数组长度的字节，而字节数组初始化时，长度指定为下次非阻断能读取到的长度，
     * 所以在此例中，不用循环就读取了文件的全部内容。
     * <p/>
     * 注意！！！
     * 这个方法有一个最大的问题，就是有可能造成内存溢出。试想如果这里读取的文件是一个1080P的电影文件，
     * 大小可能有几十个G，很有可能超出系统内存的大小，所以这个方法尽量避免使用，除非十分确定读取的文件都是小文件。
     *
     * @throws IOException
     */
    public static void readFileOnce() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/cashlu/Desktop/demo.txt");
        byte buf[] = new byte[fis.available()];
        fis.read(buf);
        System.out.println(new String(buf));
        fis.close();
    }


    public static void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/cashlu/Desktop/demo.txt");
        byte buf[] = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1) {
            /*
            上面之所以要创建变量len，并且将fis.read(buf)的返回值（本次读取到的数据长度）赋值给len，
            并且在下面的输出语句中指定String对象的长度，是因为while体内，不断的在对buf[]进行重复的赋值，
            覆盖之前的内容。
            最后一次赋值的字节个数，并不一定会刚好等于数组长度，那么数组内必然会存在一些没有被覆盖的垃圾数据。
             */
            System.out.println(new String(buf, 0, len));
        }
    }
}
