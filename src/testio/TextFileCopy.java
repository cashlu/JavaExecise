package testio;

import java.io.*;

/**
 * 文件的拷贝，实现原理是将源文件内容读入缓冲，在目的地创建目标文件，将缓冲写入。
 * Created by cashlu on 15/3/25.
 */
public class TextFileCopy {
    private File sour;
    private File dest;

    public void copy(File s, File d) {
        this.sour = s;
        this.dest = d;
        FileReader fr = null;
        FileWriter fw = null;

        //Begin to read the content of source file
        try {
            fr = new FileReader(s);
            fw = new FileWriter(d);
            char[] buffer = new char[1024];
            int num = 0;
            while ((num = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, num));
                //write the content into destination file
                fw.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File s = new File("/Users/cashlu/Desktop/demo.txt");
        File d = new File("/Users/cashlu/Desktop/demoTo.txt");

        TextFileCopy t = new TextFileCopy();
        t.copy(s, d);

    }
}
