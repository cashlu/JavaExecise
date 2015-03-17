package testException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试try/catch/finally结构体中的return
 * Created by cashlu on 14/11/28.
 */
public class TestTryCatchWithReturn {
    public static void main(String[] args) {
        String str = new TestTryCatchWithReturn().openFile();
        System.out.println(str);

    }

    /**
     * 定义openFile()方法为String类型
     * @return String 返回一个字符串，用于表示读取文件的状态
     */
    String openFile() {
        File file = new File("/Users/cashlu/Desktop/test");
        /*
            reader的声明放在try的外面，是因为要在finally中关闭资源，如果放在try中，就成了局部变量，只在代码块内有效了。
            reader要被初始化为null，因为在编译器检查时，finally中的reader.close()调用，会检查出reader没有被初始化。
            所以要初始化一个空值。
        */
        FileReader reader = null;

        /*
            在一个方法中，只能有一个return生效，在下面try/catch/finally结构中，为每一种不同的情况都设置了return的值。

            程序上需要注意控制，不要让多个return都执行，因为在try/catch/finally结构中，当执行到return时，实际上并没有马上的返回，
            而是先将该值保存起来，等finally执行完毕之后再return，那么在finally结束之前，如果有第二个return语句被执行，那么之前保存的
            return的值就会被覆盖，因为一个方法中只return一次。

            根据上面的原则，所以一般情况下，除非你真的知道自己在干什么，否则不要再finally代码块中执行return,因为finally总会被执行，
            那么之前如果有return的话，总会被finally的return给覆盖掉。
         */
        try {
            reader = new FileReader(file);
            //这里不是很严谨，因为只读取了文件中的第一个字符
            char c = (char) reader.read();
            System.out.println(c);
            return "读取成功";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "文件不存在";
        } catch (IOException e) {
            e.printStackTrace();
            return "IO异常";
            //finally代码块中不要return，除非你真的知道自己在干什么。
        } finally {
            try {
                if (reader != null) {
                    reader.close();
//                    return "文件关闭成功";
                }
            } catch (IOException e) {
                e.printStackTrace();
//                return "文件关闭失败";
            }
        }
    }
}
