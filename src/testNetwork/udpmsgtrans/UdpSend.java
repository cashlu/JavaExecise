package testNetwork.udpmsgtrans;

import java.io.IOException;
import java.net.*;

/**
 * 需求：通过UDP协议，将一段文字传输出去。
 *
 * 1、建立UDP Socket服务。
 * 2、创建要传输的数据，并将数据封装为数据包对象。
 * 3、通过Socket服务的发送方法，将数据包对象发送出去。
 * 4、释放资源。
 * Created by cashlu on 15/7/7.
 */
public class UdpSend {
    public static void main(String[] args) throws IOException {
        //1、创建UDP socket服务。
        DatagramSocket ds = new DatagramSocket(8888);
        //2、确定数据，并封装成数据包对象。
        byte[] data = "这是一段需要发送的文字".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("rMBP.local"), 10000);
        //3、通过Socket服务将数据包对象发送出去。
        ds.send(dp);
        //4、释放资源
        System.out.println("Data:" + new String(data, 0, data.length));
        System.out.println("Port:" + ds.getPort());
        ds.close();
    }
}
