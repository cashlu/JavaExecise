package testNetwork.tcptransv4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cashlu on 15/7/10.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10000);
            Socket client = null;
            while (true) {
                client = server.accept();
                String clientIp = client.getInetAddress().getHostAddress();
                System.out.println(clientIp + " is connected...");
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals("over"))
                        break;
                    System.out.println(clientIp + ":" + line);
                    /*
                    write方法需要手动加上换行，因为客户端的readline()方法是阻塞式方法，没有收到换行符，会一直等待。
                    或者使用BufferedWriter.newLine()方法。
                    */
                    bw.write(line.toUpperCase());
                    bw.newLine();
                    //一定要刷新缓冲区，否则数据会保存在缓冲区，直到缓冲区满了，否则不会发送出去。如果手动的关闭了缓冲区，则不需要flush()。
                    bw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
