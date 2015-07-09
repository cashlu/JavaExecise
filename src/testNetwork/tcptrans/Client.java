package testNetwork.tcptrans;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 创建TCP连接，向服务端发送字符串数据。
 * 1、创建Socket，指定要连接的IP和端口。
 * 2、创建输出流（这个需求不要求客户端有输入流）。
 * 3、输出流写出数据。
 * Created by cashlu on 15/7/8.
 */
public class Client {
    public static void main(String[] args) {
        try(Socket s = new Socket("127.0.0.1", 8888);
            OutputStream out = s.getOutputStream()) {
            String msg = "Nice to connecting you";
            out.write(msg.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
