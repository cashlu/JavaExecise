package testio.testPipedStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 测试管道流。
 * Created by cashlu on 15/4/28.
 */
public class PipedStreamDemo {
    public static void main(String[] args) {
        //创建输入、输出管道流。
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        try {
            //将两个管道流连接起来
            in.connect(out);
            Reader reader = new Reader(in);
            Sender sender = new Sender(out);
            new Thread(reader).start();
            new Thread(sender).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
