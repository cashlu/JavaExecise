package testException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cashlu on 14/11/28.
 */
public class TestReadFile {
    public static void main(String[] args) {
        File file = new File("/Users/cashlu/Desktop/test");
        //reader的声明放在try的外面，是因为要在finally中关闭资源，如果放在try中，就成了局部变量，只在代码块内有效了。
        //reader要被初始化为null，因为在编译器检查时，finally中的reader.close()调用，会检查出reader没有被初始化。所以要初始化一个空值。
        FileReader reader = null;



        try {
            reader = new FileReader(file);
            char c = (char) reader.read();
            System.out.println(c);

            /**
             * FileNotFoundException异常可以不捕获，因为其是IOException的子类，
             * 根据JAVA多态的原则，IOException一样可以处理这个异常。
             *
             * 如果两个异常都分开捕获的话，那么一定要注意顺序。一般的顺序的是先从子类开始处理。
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File is NOT exists");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //这里再次捕获异常，是因为reader调用close()方法时，需要检查reader所引用的对象是否存在。

                //这里判断reader是否为空，是出于代码严谨考虑，避免之前new对象的时候失败。
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
