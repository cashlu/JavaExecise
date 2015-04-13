package testio.StreamDemo;

import java.io.*;

/**
 * 键盘输入，终端输出显示。
 * 1、确认输入流为System.in, 输出流为System.out。
 * 2、因为System.in实际上是InputStream类的对象，是一个字节流，需转为字符流，用Reader中的转换流InputStreamReader(注意命名方式)。
 * 3、控制台输出是System.out，是OutputStream类的对象，同上，用OutputStreamWriter转换。
 * Created by cashlu on 15/4/13.
 */
public class KeyboardToTerminal {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);

        //字符流的缓冲区是BufferedReader和BufferedWriter
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        while (true){
            try {
                StringBuilder sb = new StringBuilder(br.readLine());
                if (sb.toString().equals("over")){
                    break;
                }
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (br != null){
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bw != null){
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
