package testNetwork.tcptransv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 需求：客户端通过TCP协议向服务端发送数据，服务端接收到数据后，向客户端返回数据。
 * 1、创建客户端Scoket对象，并指定服务端的IP和端口。
 * 2、创建客户端输出流，发送数据。
 * 3、创建客户端输入流，接收数据。
 * 4、处理并打印输入流接收到的数据。
 * Created by cashlu on 15/7/10.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket s  = new Socket("127.0.0.1", 9999);
            String msgOut = "Goodbye, my darling";
            OutputStream out = s.getOutputStream();
            out.write(msgOut.getBytes());
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String msgIn = new String(buf, 0, len);
            System.out.println("Server say: " + msgIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
