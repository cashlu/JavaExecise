package testNetwork.udpmsgtransv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * 需求：从键盘读取输入流，将输入的字符串发送到接收端。
 *
 * 1.建立Socket对象，指定发送端口。
 * 2.键盘读取字符串，将字符串封装为DatagramPacket对象。
 * 3.通过Socket对象的send()方法将DatagramPacket对象发送出去。
 * 4.释放资源。
 * Created by cashlu on 15/7/7.
 */
public class UdpSendv2 {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        BufferedReader br = null;
        try {
            ds = new DatagramSocket(8888);
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String msg = br.readLine();
                if (msg.equals("OVER")) {
                    break;
                }
                byte[] data = msg.getBytes();
                //末尾的端口号是对端的端口，因为单机测试，所以上面创建DatagramSocket时绑定的端口必须区分开。
//                DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("rMBP.local"), 9999);
                DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9999);
                ds.send(dp);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
