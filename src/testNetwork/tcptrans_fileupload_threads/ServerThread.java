package testNetwork.tcptrans_fileupload_threads;

import java.io.*;
import java.net.Socket;

/**
 * 服务器端的线程体代码。封装了除了创建服务器端ServerSocket对象以外的其他代码。
 * Created by cashlu on 15/7/21.
 */
public class ServerThread implements Runnable {
    private Socket client;
    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        BufferedOutputStream bos = null;
        String clientIP = client.getInetAddress().getHostAddress();
        System.out.println(clientIP + " connected...");
        long time = System.currentTimeMillis();
        try {
            BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
            //用于读取文件名
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String fileName = br.readLine();
            System.out.println("文件名已接收");
            System.out.println("FileName: " + fileName);
            File file = new File("/Users/cashlu/Desktop/tt/" + time + fileName);
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
            System.out.println(clientIP + " 上传失败");
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
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
