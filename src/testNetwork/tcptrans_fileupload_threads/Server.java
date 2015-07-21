package testNetwork.tcptrans_fileupload_threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的服务器端。将业务逻辑代码封装进线程内。
 * Created by cashlu on 15/7/21.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(10000);
            while (true) {
                Socket client = server.accept();
                new Thread(new ServerThread(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
