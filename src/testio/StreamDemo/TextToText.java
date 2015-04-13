package testio.StreamDemo;

import java.io.*;

/**
 * 将一个文本文件的内容，复制到另一个文本文件中。
 * 1、确认输入流为FileReader, 输出流为FileWriter
 * 2、使用缓冲，输入流缓冲为BufferedReader, 输出流缓冲为BufferedWriter
 * Created by cashlu on 15/4/12.
 */
public class TextToText {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("/Users/cashlu/Desktop/src.txt"));
            bw = new BufferedWriter(new FileWriter("/Users/cashlu/Desktop/dest.txt"));
            int ch;
            while ((ch = br.read()) != -1){
                System.out.print((char) ch);
                bw.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
