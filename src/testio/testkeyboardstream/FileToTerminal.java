package testio.testkeyboardstream;

import java.io.*;

/**
 * Created by cashlu on 15/4/12.
 */
public class FileToTerminal {
    public static void main(String[] args) throws IOException {
        //创建输入、输出流对象，指向标准输入、输出。
        //这是键盘录入的最常见的写法。
        InputStream in = System.in;
        OutputStream out = System.out;

        InputStreamReader isr = new InputStreamReader(in);
        OutputStreamWriter osw = new OutputStreamWriter(out);

        //将输入流改为一个文件的读取流。
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/cashlu/Desktop/file.txt")));
        BufferedWriter bw = new BufferedWriter(osw);
        //可以用一个语句来替换上面的三个语句，使用了匿名对象。
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null){
            if (line.equals("over")){
                break;
            }
            bw.write(line.toUpperCase());
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
