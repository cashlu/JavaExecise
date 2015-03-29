package testio;

import java.io.*;

/**
 * 通过缓存读写（BufferedReader/BufferedWriter）来复制文本文件。
 * Created by cashlu on 15/3/30.
 */
public class BufferedCopyTextFile {
    public static void main(String[] args) {
        File s = new File("/Users/cashlu/Desktop/demo.txt");
        File d = new File("/Users/cashlu/Desktop/demoTo.txt");
        copy(s, d, true);

    }

    /**
     * 文本文件通过缓存复制的方法。
     * @param s 源文件
     * @param d 目的地文件
     * @param isAppend 是否追加到末尾
     */
    private static void copy(File s, File d, boolean isAppend) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(s));
            bw = new BufferedWriter(new FileWriter(d, isAppend));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                //BufferedReader()方法不读取换行符，所以需要手工换行。
                bw.newLine();
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
