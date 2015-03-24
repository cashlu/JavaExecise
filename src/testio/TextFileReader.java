package testio;

import java.io.*;

/**
 * IO的文件读取操作。
 * Created by cashlu on 15/3/20.
 */
public class TextFileReader {
    public static void main(String[] args) {
        /*
        1、先创建一个File对象，用于后续的操作。（不创建也行，write和read方法都可以直接读取String类的路径）。
        2、创建FileWriter对象，用于创建文件。
        3、调用FileWriter.write()方法，用于将文字写入缓冲。
        4、调用FileWriter.close()方法，将缓冲写入文件并关闭资源。
        5、创建FileReader对象，用于读取文件。
        6、调用FileReader.read()方法，读取内容并输出。
        7、调用FileReader.close()方法，关闭资源。
         */
        File f = new File("/Users/cashlu/Desktop/demo.txt");

        FileWriter fw = null;

        try {
            fw = new FileWriter(f, true);
            fw.write("这是写入或者追加的内容\n再写入一些内容\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileReader fr = null;

        /*
        读文件内容要捕获两个异常：
        1、文件不存在异常
        2、IO异常
         */
        try {
            fr = new FileReader(f);
            int ch;
                /*
                read()方法一次返回一个char，用int表示，范围在0-65535，如果返回-1，代表文件末尾。
                所以循环体内要判断-1，print()要强制类型转换。
                 */
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------");


        try {
            fr = new FileReader(f);
            char[] buffer = new char[1024];
            int num = 0;
            while ((num = fr.read(buffer)) != -1){
                System.out.println(new String(buffer, 0, num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
