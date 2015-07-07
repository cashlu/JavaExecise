package testNetwork.udpmsgtransv3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 消息的接受类。
 * Created by cashlu on 15/7/7.
 */
public class Receive implements Runnable {
    private DatagramSocket ds;

    public Receive(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                String msg = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + " :: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
