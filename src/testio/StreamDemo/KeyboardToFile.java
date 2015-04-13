package testio.StreamDemo;

import java.io.*;

/**
 * 将键盘输入写入文本文件。
 * 1、键盘输入为输入流System.in，是InputStream的对象,需要用InputStreamReader转换流来转换为字符流（因为要写入文件）。
 * 2、输出流为文本文件写入，为FileOutputStream，为字节流，需要用OutputStreamWriter转换为字符流。
 * 2、写入文本文件，输出流为FileWriter,提升性能，需要用到缓冲流BufferedWriter。
 * Created by cashlu on 15/4/13.
 */
public class KeyboardToFile {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/cashlu/Desktop/file.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        String line;
        StringBuilder line;
        try {
            while ((line = new StringBuilder(br.readLine())) != null) {
                if (line.toString().equals("over"))
                    break;
                System.out.println(line.toString().toUpperCase());
                bw.write(line.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
