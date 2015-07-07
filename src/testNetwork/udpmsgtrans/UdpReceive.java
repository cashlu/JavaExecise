package testNetwork.udpmsgtrans;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 需求：接收udp协议发送过来的数据。
 *
 * 1、建立UDP Socket服务，指定监听端口。
 * 2、定义一个空的数据包对象，用于存储接收到的字节数据。
 * 3、通过Socket的receive方法接收数字节数据，并存储进数据包对象。
 * 4、解析数据包对象的内容，将其打印在控制台。
 * 5、释放资源。
 *
 * Created by cashlu on 15/7/7.
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        //创建udp socket服务，监听10000端口。
        DatagramSocket ds = new DatagramSocket(10000);
        //创建缓冲区字节数组
        byte[] buf = new byte[1024];
        //创建数据包对象，用于存储接收到的数据。（用于发送和接收的DatagramPacket对象，构造函数不一样）
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        //接收数据（阻塞式）
        ds.receive(dp);
        //解析接收到的数据
        String ip = dp.getAddress().getHostAddress();
        int dataLen = dp.getLength();
//        String data = dp.getData().toString();
        //上面背注释的代码也可以，但是会生成1024长度的字符串，而下面这句更合理，只生成合适长度的字符串。
        String data = new String(dp.getData(), 0, dp.getLength());
        int port = dp.getPort();
        System.out.println(ip + ":" + port);
        System.out.println(data + "(" + dataLen + ")");
        //释放资源
        ds.close();
    }
}
