package testio.myencode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 测试字符串与字节之间的编码及解码。
 * Created by cashlu on 15/6/4.
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好";
        //编码
        byte buf1[] = s.getBytes("GBK");
        System.out.println(buf1);
        System.out.println(Arrays.toString(buf1));
        String s1 = new String(buf1, "iso8859-1");
        System.out.println(s1);

        //UTF-8会出错，因为编码方式不一致，ISO8859-1刚好没错，是因为他本身不识别中文，码表中没有冲突
        byte buf2[] = s1.getBytes("iso8859-1");
        String s2 = new String(buf2, "gbk");
        System.out.println(s2);
    }


}
