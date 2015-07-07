package testNetwork.udpmsgtransv3;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by cashlu on 15/7/7.
 */
public class Chat {
    public static void main(String[] args) {
        try {
            DatagramSocket dss = new DatagramSocket(30000);
            DatagramSocket dsr = new DatagramSocket(20000);
            new Thread(new Send(dss)).start();
            new Thread(new Receive(dsr)).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
