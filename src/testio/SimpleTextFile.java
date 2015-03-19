package testio;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 测试学习JAVA IO流的使用。
 * 在硬盘上创建一个文件，并向文件中添加一些文字。
 * Created by cashlu on 15/3/19.
 */
public class SimpleTextFile {
    public static void main(String[] args) throws IOException {
        /*
        创建FileWriter对象，会在路径位置创建文件。
        如果该文件存在，则会被覆盖！！！
         */
        FileWriter fw = new FileWriter("/Users/cashlu/Desktop/demo.txt");
//        File f = new File("/Users/cashlu/Desktop/demo2");
//        FileWriter fileWriter = new FileWriter(f);

        //调用write()方法，这时候字符串还没有写入文件，只是写入到了流中。
        fw.write("God damn China Mobile ah\n");
        //将缓冲区清空，并且将缓冲的字符串写入文件中。
        fw.flush();

        //字符串会被追加到目的地中。而不是覆盖。
        fw.write("哈哈哈哈哈\n");
        fw.flush();

        //将缓冲的字符串写入文件后，关闭流资源。
        fw.write("My name is Simon Lo...\n");
        fw.close();
    }
}
