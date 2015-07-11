package testNetwork.tcptransv3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：通过TCP协议接收客户端发来的文本，将文本转化为大写后，返回给客户端。
 * Created by cashlu on 15/7/10.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10000);
            Socket client = serverSocket.accept();
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            while (true){
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                String msgIn = new String(buf, 0, len);
                String msgOut = msgIn.toUpperCase();
                out.write(msgOut.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
