package testio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 测试LineNumberReader的使用方法。LineNumberReader类也是一个装饰类。
 * Created by cashlu on 15/4/2.
 */
public class TestLineNumberReader {
    public static void main(String[] args) {
        FileReader fr = null;
        LineNumberReader lnr = null;
        try {
            fr = new FileReader("/Users/cashlu/Desktop/demo.txt");
            lnr = new LineNumberReader(fr);
            String line;
            while ((line = lnr.readLine()) != null){
                //同时输出行号
                System.out.println(lnr.getLineNumber() + "\t|\t" + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                lnr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
