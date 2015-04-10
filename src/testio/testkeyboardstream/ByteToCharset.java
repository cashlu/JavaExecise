package testio.testkeyboardstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * An InputStreamReader is a bridge from byte streams to character streams:
 * It reads bytes and decodes them into characters using a specified charset.
 * The charset that it uses may be specified by name or may be given explicitly,
 * or the platform's default charset may be accepted.
 *
 * 这个程序是KeyboardInputStream的重新实现，利用了字符流的readline()方法读取一行的特性
 * 和BufferedRead类的缓冲区特性。不必自己实现读取一行及判断换行符的一些细节。
 * Created by cashlu on 15/4/11.
 */
public class ByteToCharset {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        //将字节流InputStream转换为字符流，转换成字符流的目的是为了可以使用字符流的缓冲BufferedReader
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);

        while (true){
            StringBuilder sb = new StringBuilder(br.readLine());
            if (sb.toString().equals("over")){
                break;
            }
            System.out.println(sb.toString());
        }

    }
}
