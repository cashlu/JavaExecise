package testio.StreamDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cashlu on 15/4/13.
 */
public class ExceptionToFile {
    public static void main(String[] args) {
        int arr[] = new int[2];
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("/Users/cashlu/Desktop/log.txt"));
            System.out.println(arr[3]);
        } catch (Exception e) {
            e.printStackTrace();
            writeLog(bw, e);
        }
    }

    /**
     * 该方法的功能是将本来应该输出到控制台的异常信息，输出到文本文件中。
     * @param bw BufferedWriter对象，封装输出异常的目的地文件。
     * @param e 有可能抛出的异常对象。
     */
    private static void writeLog(BufferedWriter bw, Exception e){
        try {
            bw.write(e.toString());
            bw.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
