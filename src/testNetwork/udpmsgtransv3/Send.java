package testNetwork.udpmsgtransv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 消息的发送类。
 * Created by cashlu on 15/7/7.
 */
public class Send implements Runnable {
    private DatagramSocket ds;

    public Send(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = br.readLine()) != null){
                if (msg.equals("over")){
                    break;
                }
                byte[] buf = msg.getBytes();
                //这里的20000端口，是对端的监听端口，而不是本地的发送端口
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 20000);
                ds.send(dp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
