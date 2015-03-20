package testio;

import java.io.FileWriter;
import java.io.IOException;

/**
 * IO异常的处理。
 * Created by cashlu on 15/3/19.
 */


public class SimpleTextFileWriterWithException {
    /**
     * 创建FileWriter指向放在最上层，是因为如果放在try代码块内，finally访问不到。
     * fw.close()放在finally内的嵌套try代码块内，并且被if()包裹，是因为关闭资源的操作永远要执行，
     * 但是如果资源不存在，可能会抛异常，所以放在try内，并且，如果对象本身不存在，就不用执行，所以需要
     * if()做判断。
     * 这是FileIO的特殊异常处理机制。
     * @param args
     */
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("/Users/cashlu/Desktop/demo.txt");
            fw.write("测试一下字符串的写入");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
