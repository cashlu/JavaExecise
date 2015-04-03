package testio.mylinenumberreader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试MyLineNumberReader类。
 * Created by cashlu on 15/4/2.
 */
public class Test {
    public static void main(String[] args) {
        FileReader fr = null;
        MyLineNumberReader mlnr = null;
        try {
            String line = null;
            fr = new FileReader("/Users/cashlu/Desktop/demo .txt");
            mlnr = new MyLineNumberReader(fr);
            while ((line = mlnr.readLine()) != null) {
                System.out.println(mlnr.getLineNum() + "\t|\t" + line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mlnr.close();
        }
    }
}