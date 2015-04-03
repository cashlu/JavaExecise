package testio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用FileStream来实现二进制文件（包括文本文件）的复制。
 * 1、创建FileInputStream和FileOutStream的对象。
 * 2、创建缓冲区。
 * 3、读入源文件数据写入缓冲，再将缓冲内数据写入目标文件。如此循环，直到完成。
 * 4、关闭资源。
 * <p/>
 * Created by cashlu on 15/4/3.
 */
public class MediaFileCopyDemo {
    public static void main(String[] args) {
        File in = new File("/Users/cashlu/Downloads/JAVA学习路线图.png");
        File out = new File("/Users/cashlu/Desktop/JAVA.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(in);
            fos = new FileOutputStream(out);

            byte buf[] = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            System.out.println("文件复制完成");
        } catch (IOException e) {
            throw new RuntimeException("文件复制失败");
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException("读取关闭失败");
            }

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException("写入关闭失败");
            }
        }
    }
}
