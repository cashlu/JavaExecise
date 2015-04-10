package testio.testkeyboardstream;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cashlu on 15/4/10.
 */
public class KeyboardInputStream {
    public static void main(String[] args) throws IOException {
        //System.in中的in，实际上是System类中一个InputStream类常量，所以可以这样定义赋值。
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        /**
         * 循环读取键盘输入，当遇到换行符，则判断输入的字符数组是否是"over"，如果不是则输出数组，
         * 如果是，则中断循环。
         */
        while (true){
            int ch = in.read();
            //判断\r是为了兼容Win，因为Win的换行符是\r\n
            if (ch == '\r'){
                continue;
            }
            if (ch == '\n'){
                String s = sb.toString();
                if (s.equals("over")){
                    break;
                }
                System.out.println(s);
                //每次循环都清空字符串。
                sb.delete(0, sb.length());
            }
            else{
                sb.append((char)ch);
            }
        }
    }
}
