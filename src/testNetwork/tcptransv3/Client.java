package testNetwork.tcptransv3;

import java.io.*;
import java.net.Socket;

/**
 * 需求：通过键盘录入，将文本通过TCP发送给服务端，服务端将文本转换为大写后，返回给客户端。
 * Created by cashlu on 15/7/10.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("192.168.1.104", 10000);
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.print("Enter the message:");
                String msgOut = br.readLine();
                out.write(msgOut.getBytes());
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                String msgIn = new String(buf, 0, len);
                System.out.println("Server retuen: " + msgIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
