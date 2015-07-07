package testNetwork.udpmsgtransv2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 需求：接收发送端发来的数据。
 *
 * 1.创建UDP Socket对象，绑定监听端口。
 * 2.创建一个字节缓冲区，以及空的DatagramPacket对象，用于存储接收到的数据。
 * 3.通过DatagrameSocket的receive()方法接收数据。
 * 4.对接收到的数据进行解析，输出到控制台。
 * Created by cashlu on 15/7/7.
 */
public class UdpReceivev2 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(9999);
            //创建空的字节缓冲区
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            while (true){
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                String hostname = dp.getAddress().getHostName();
                String data = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + " :: " + data);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
