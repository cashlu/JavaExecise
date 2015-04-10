package testio.testkeyboardstream;

import java.io.*;

/**
 * 实现输入字符流到输出字节流的转换。
 * 实现的效果是，键盘输入字符，屏幕输出。
 * Created by cashlu on 15/4/11.
 */
public class CharsetToByte {
    public static void main(String[] args) throws IOException {
        //创建输入、输出流对象，指向标准输入、输出。
        //这是键盘录入的最常见的写法。
        InputStream in = System.in;
        OutputStream out = System.out;

        InputStreamReader isr = new InputStreamReader(in);
        OutputStreamWriter osw = new OutputStreamWriter(out);

        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        //可以用一个语句来替换上面的三个语句，使用了匿名对象。
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
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
