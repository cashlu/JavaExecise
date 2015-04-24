package testio.testprintstream;

import java.io.*;

/**
 * Created by cashlu on 15/4/20.
 */
public class PrintStreamDemo {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter (System.out, true);
        //也可以输出到文件。
        File file = new File("/Users/cashlu/Desktop/test.txt");
        PrintWriter pw = null;
        try {
//            pw = new PrintWriter(file);
            /*
            将文件封装在FileWriter中，可实现写入的自动刷新。
            而上面没有，所以只有循环全部结束后，执行close()方法时，才会刷新一次。
            查看PrintWriter的构造器方法可以看出，PrintWriter可以接收Writer对象作为其参数传入。
            FileWriter是Writer的子类。

            注意：true参数是PrintWriter的参数，代表自动刷新。
                 FileWriter也可以接收一个true参数，代表是对文件内容进行追加。

            如果想提高效率，还可以用BufferedWriter装饰FileWriter对象。
             */
            pw = new PrintWriter(new FileWriter(file), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = br.readLine()) != null){
                if (line.equals("over")){
                    break;
                }
                pw.println(line.toUpperCase());
//                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
