package testio.StreamDemo;

import java.io.*;

/**
 * 拷贝二进制文件。
 * 1、确认输入流为FileInputStream, 输出流为FileOutputStream。
 * 2、输入流缓冲为BufferedInputStream, 输出流缓冲为BufferedOutputStream。
 *
 * Created by cashlu on 15/4/12.
 */
public class BinToBin {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/只想一生跟你走.mp3"));
            bos = new BufferedOutputStream(new FileOutputStream("/Users/cashlu/Desktop/只想一生跟你走(copy).mp3"));
            int by = 0;
            while ((by = bis.read()) != -1){
                bos.write(by);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
