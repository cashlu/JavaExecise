package testNetwork.tcptrans;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：将客户端发送过来的字符串数据打印到控制台。(本例中没有关闭客户端的资源，实际开发中需要关闭)
 *
 * 1、创建服务端Socket对象，并监听某一个指定端口。
 * 2、等待接收客户端数据。
 * 3、打印数据。
 * Created by cashlu on 15/7/8.
 */
public class Server {
    public static void main(String[] args) {
        try {
            //创建服务端ServerSocket对象，绑定监听端口8888。
            ServerSocket server = new ServerSocket(8888);
            //accept()方法返回一个Socket对象，也就是客户端的Socket对象。
            Socket s = server.accept();
            //获取客户端IP
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + " is connected");
            //创建一个输入流来读取客户端流对象的输入信息。
            InputStream in = s.getInputStream();
            //利用缓冲区来读取输入流对象的数据，并打印到控制台。
            byte[] buf = new byte[1024];
            int len = in.read(buf); //InputStream对象的read()方法，读取输入流对象的内容，并返回读取内容的长度。
            System.out.println(ip + "::" + new String(buf, 0, len));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
