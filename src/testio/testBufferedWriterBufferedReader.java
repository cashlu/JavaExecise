package testio;

import java.io.*;

/**
 * 测试BufferedWriter的使用。
 * 要使用BufferedWriter对性能进行提升，必须先创建FileWriter对象。
 * 为了使代码清晰易懂，这里对异常不做处理，而是抛出去。
 * Created by cashlu on 15/3/29.
 */
public class testBufferedWriterBufferedReader {
    private static void writer(File f) throws IOException {
        int count = 1;
        FileWriter fw = null;
        fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        while (count <= 100000) {
            bw.write(count + "\t");
            //每写入十个数字后换行。newLine()方法与OS无关，比\n或者\r\n容错性更强。
            if (count % 10 == 0) {
                bw.newLine();
            }
            bw.flush();
            count++;
        }
        //关闭缓冲区实际上就是在关闭资源对象，所以不用再单独关闭fw了。
        bw.close();
    }

    private static void reader(File f) throws IOException {
        FileReader fr = null;
        fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        //readline()如果读到文件末尾，会返回null，可将其作为判断条件来读取整个文本。
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        File f = new File("/Users/cashlu/Desktop/BufferedDemo.txt");
        writer(f);
        reader(f);

    }
}
