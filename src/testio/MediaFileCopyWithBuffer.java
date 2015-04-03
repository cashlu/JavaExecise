package testio;

import java.io.*;

/**
 * 利用字节流缓冲区来赋值二进制文件，是MediaFileCopyDemo的升级版本。
 * MediaFileCopyDemo是自己创建了一个数组用于缓冲区，而这里用JDK提供的对象来实现。
 * Created by cashlu on 15/4/3.
 */
public class MediaFileCopyWithBuffer {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        copy();
        long end = System.currentTimeMillis();
        System.out.println("拷贝耗时：" + (end - start) + "毫秒");
    }

    public static void copy(){
        File in = new File("/Users/cashlu/Downloads/CDImage.flac");
        File out = new File("/Users/cashlu/Desktop/CDImage.flac");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(in);
            fos = new FileOutputStream(out);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            int by = 0;
            while ((by = bis.read()) != -1) {
                bos.write(by);
            }
            System.out.println("拷贝完成");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
