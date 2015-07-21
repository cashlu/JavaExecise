package testNetwork.tcptrans_textfile;

import java.io.*;
import java.net.Socket;

/**
 * 客户端向服务器端发送文本文件。
 * Created by cashlu on 15/7/20.
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        BufferedReader bufr = null;
        try {
            client = new Socket("127.0.0.1", 20000);
            bufr = new BufferedReader(new FileReader("/Users/cashlu/Desktop/test.txt"));
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            String time = String.valueOf(System.currentTimeMillis());

            String line = null;
            while ((line = bufr.readLine()) != null) {
                pw.println(line);
            }
            /*
            文件传输完成后，给服务器端一个信号，关闭输出流。这样可以避免客户端传输完成后，服务器端while循环的等待。

            客户端之所以可以正常跳出循环，是因为读取文件，用readline()方法，判断了是否等于null。readline()方法当读到了文件的结尾，
            也就是读到了null后，while循环会终止。而客户端并不会将null发送给服务器端，所以服务器端不会跳出循环。
             */
            client.shutdownOutput();
            /*
            客户端循环发送结束后，服务器端并不知道已经结束，一直会阻塞等待，所以客户端需要给服务端发送一个结束标记。
            常规的做法是，客户端先将标记发过去，让服务端知道标记是什么，然后再发送数据。这样就不用在服务端将标记写死。
            不过这样写，标记还是有可能和发送的正文冲突，造成文件接收不完整。那么可以使用时间戳作为结束标记。但是使用时间戳作为
            标记，会使得代码中使用过多的流对象，比较繁琐。
            */
//            pw.println("over");
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String reply = bufIn.readLine();
            System.out.println(reply);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufr != null) {
                    bufr.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
