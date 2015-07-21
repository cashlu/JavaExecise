package testNetwork.tcptrans_fileupload_threads;

import java.io.*;
import java.net.Socket;

/**
 * 客户端：向服务器端发送图片文件。
 * 1、创建客户端Socket对象，指定服务器端的IP及监听端口。
 * 2、创建图片的File对象，指向特定文件。
 * 3、创建Socket的读取流对象和发送流对象。
 * 4、获取文件名，并向服务器端发送文件名，以便创建文件对象。
 * 5、循环内发送文件。
 * 6、创建Socket接收流对象，用于接收服务器返回的发送状态信息。
 * 7、关闭发送流。
 * 8、关闭其他资源（文件读取流和Socket）。
 * Created by cashlu on 15/7/20.
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        BufferedInputStream bis = null;
        try {
            client = new Socket("127.0.0.1", 10000);
            File file = new File("/Users/cashlu/Downloads/侏罗纪世界.mp4");
//            File file = new File("c:/ddd/test.jpg");
            bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            /*
            这里一定要加上他妈的参数true！！！
            这里一定要加上他妈的参数true！！！
            这里一定要加上他妈的参数true！！！
            重要的话说三遍！！！
             */
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            //向服务器端发送文件名。
            String fileName = file.getName();
            System.out.println("读取的文件名：" + fileName);
            pw.println(fileName);
            System.out.println("文件名已发送");
            //开始读取并传输文件
            int by = 0;
            while ((by = bis.read()) != -1) {
                bos.write(by);
            }
            //文件传输完成，关闭输出流。
            client.shutdownOutput();
            //接收服务器端返回的完成信息。
            String reply = br.readLine();
            System.out.println(reply);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
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
