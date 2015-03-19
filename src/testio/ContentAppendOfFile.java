package testio;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 对已存在文件的内容进行追加。也就是说创建对象的时候，不能将原有的文件覆盖。
 * Created by cashlu on 15/3/19.
 */
public class ContentAppendOfFile {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            /*
            FileWriter的其中一个带参构造器函数，append=true代表是内容追加，
            如果文件不存在，则创建文件，如果文件存在，则不创建文件，内容仅追加。
             */
            fw = new FileWriter("/Users/cashlu/Desktop/demo.txt", true);
            fw.write("\n这是追加的内容");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
