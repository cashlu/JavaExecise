package testNetwork.tcptransv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：服务器端监听某一端口，当收到客户端通过TCP协议发送的数据时，向客户端返回一个字符串数据。
 * 1、建立ServerSocket对象，指定监听的端口。
 * 2、
 * Created by cashlu on 15/7/10.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            //服务端开始等待接收数据，并创建客户端Socket对象的引用。
            Socket s = serverSocket.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + " has connected...");
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String msgIn = new String(buf, 0, len);
            System.out.println("CLient say: " + msgIn);
            String msgOut = "I got it!";
            out.write(msgOut.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
