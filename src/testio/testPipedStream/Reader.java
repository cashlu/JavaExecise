package testio.testPipedStream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by cashlu on 15/4/28.
 */
public class Reader implements Runnable {
    private PipedInputStream in;

    public Reader(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        byte[] buf = new byte[1024];
        try {
            int len = in.read(buf);
            String s = new String(buf, 0, len);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
