package testio;

import java.io.*;

/**
 * 文件的拷贝，实现原理是将源文件内容读入缓冲，在目的地创建目标文件，将缓冲写入。
 * Created by cashlu on 15/3/25.
 */
public class TextFileCopy {
    private File sour;
    private File dest;
    private boolean isAppend;

    /**
     * 文件拷贝方法。
     *
     * @param s      源文件
     * @param d      目标文件，不存在则创建
     * @param append 是否追加拷贝，如果该参数为true，并且该目标文件存在时，则向目标文件结尾追加拷贝。
     */
    public void copy(File s, File d, boolean append) {
        this.sour = s;
        this.dest = d;
        this.isAppend = append;

        FileReader fr = null;
        FileWriter fw = null;

        //Begin to read the content of source file
        try {
            fr = new FileReader(s);
            fw = new FileWriter(d, isAppend);
            char[] buffer = new char[1024];
            int len = 0;
            while ((len = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
                //write the content into destination file
                fw.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        File s = new File("/Users/cashlu/Desktop/demo.txt");
        File d = new File("/Users/cashlu/Desktop/demoTo.txt");
        File as = new File("/Users/cashlu/Desktop/湟源县农牧局通讯录导入SQL.txt");

        TextFileCopy t = new TextFileCopy();
        t.copy(s, d, false);
        t.copy(as, d, true);
    }
}
