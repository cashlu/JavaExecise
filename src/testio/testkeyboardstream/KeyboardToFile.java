package testio.testkeyboardstream;

import java.io.*;

/**
 * Created by cashlu on 15/4/12.
 */
public class KeyboardToFile {
    public static void main(String[] args) throws IOException {
        //创建输入、输出流对象，指向标准输入、输出。
        //这是键盘录入的最常见的写法。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //将输出流改为文件
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/cashlu/Desktop/file.txt")));
        //可以用一个语句来替换上面的三个语句，使用了匿名对象。
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null){
            if (line.equals("over")){
                break;
            }
            bw.write(line.toUpperCase());
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
