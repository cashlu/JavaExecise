package testio.mybufferedreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试自定义类MyBufferedReader。
 * Created by cashlu on 15/4/1.
 */
public class Test {
    public static void main(String[] args) {
        File f = new File("/Users/cashlu/Desktop/demo.txt");
        FileReader fr = null;
        MyBufferedReader mbr = null;
        try {
            fr = new FileReader(f);
            mbr = new MyBufferedReader(fr);
            String line = null;
            while ((line = mbr.myReadLine()) != null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mbr.close();
        }
    }
}
