package testNetwork.tcptrans_picfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端：接收客户端发来的文件。
 * 1、创建服务器端的ServerSocket对象，并绑定监听端口。
 * 2、接收客户端发来的文件名。
 * 3、用客户端发来的文件名创建File对象。
 * 4、创建Socket输入流来接收文件。
 * 5、接收完成后，通过输出流向客户端返回成果信息。
 * 6、关闭资源。
 * Created by cashlu on 15/7/20.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        BufferedOutputStream bos = null;        //用于写入文件。
        try {
            server = new ServerSocket(10000);
            client = server.accept();
            BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
            //用于读取文件名
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String fileName = br.readLine();
            System.out.println("文件名已接收");
            System.out.println("FileName: " + fileName);
            File file = new File("/Users/cashlu/Desktop/tt/" + fileName);
//            File file = new File("c:/" + fileName);
            System.out.println("新的文件：" + file.getAbsolutePath());
            bos = new BufferedOutputStream(new FileOutputStream(file));
            //开始循环接收文件
            int by = 0;
            while ((by = bis.read()) != -1) {
                bos.write(by);
            }
             /*
            这里一定要加上他妈的参数true！！！
            这里一定要加上他妈的参数true！！！
            这里一定要加上他妈的参数true！！！
            重要的话说三遍！！！
             */
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            pw.println("接收完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
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
