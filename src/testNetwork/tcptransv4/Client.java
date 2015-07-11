package testNetwork.tcptransv4;

import java.io.*;
import java.net.Socket;

/**
 * 在tcptansv3的基础上进行改进，因为处理的是文本，所以可以充分利用各种缓冲流技术。
 * Created by cashlu on 15/7/10.
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        BufferedReader br = null;
        try {
            client = new Socket("127.0.0.1", 10000);
            //定义键盘读取的流对象。
            br = new BufferedReader(new InputStreamReader(System.in));
            //定义目的，将数据写出到socket输出流，发给服务端。
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            //定义读取服务器端返回数据的读取流。
            BufferedReader brIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null){
                if (line.equals("over")){
                    break;
                }
                /*
                write方法需要手动加上换行，因为服务端的readline()方法是阻塞式方法，没有收到换行符，会一直等待。
                或者使用BufferedWriter.newLine()方法。
                 */
                bw.write(line);
                bw.newLine();
                //一定要刷新缓冲区，否则数据会保存在缓冲区，直到缓冲区满了，否则不会发送出去。如果手动的关闭了缓冲区，则不需要flush()。
                bw.flush();
                System.out.println("Server reply: " + brIn.readLine());
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }finally {
            try {
//                client.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
