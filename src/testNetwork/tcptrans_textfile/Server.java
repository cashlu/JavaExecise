package testNetwork.tcptrans_textfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端向服务器端发送文本文件。
 * Created by cashlu on 15/7/20.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        PrintWriter pwWriter = null;
        try {
            server = new ServerSocket(20000);
            client = server.accept();
            String clientIP = client.getInetAddress().getHostAddress();
            System.out.println(clientIP + " connected...");
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            pwWriter = new PrintWriter(new FileWriter("/Users/cashlu/Desktop/test111111.txt"), true);
            pwWriter = new PrintWriter("/Users/cashlu/Desktop/test111111.txt", "utf-8");
//            pwWriter = new PrintWriter("c:/test.txt", "utf-8");
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String line = null;
            while ((line = bufIn.readLine()) != null) {
                pwWriter.println(line);
            }
            PrintWriter pwOut = new PrintWriter(client.getOutputStream(), true);
            pwOut.println("上传成功");
            System.out.println("接收完成");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pwWriter != null) {
                    pwWriter.close();
                }
                if (client != null) {
                    client.close();
                }
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
