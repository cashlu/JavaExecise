package testio.testPipedStream;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by cashlu on 15/4/28.
 */
public class Sender implements Runnable {
    private PipedOutputStream out;

    public Sender(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (i++ < 10)
                out.write("Data is comming...\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
