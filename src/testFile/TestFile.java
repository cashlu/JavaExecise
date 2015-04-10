package testFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by cashlu on 14/11/27.
 */
public class TestFile {
    public static void main(String[] args) {
        /**
         * 测试File类的不同构造器函数
         * f是一个文件
         * d是一个目录
         * f2是d目录下的一个文件
         */
        File f = new File("/Users/cashlu/Desktop/test");
        File d = new File("/Users/cashlu/Desktop");
        File f2 = new File(d, "湟源县农牧局通讯录导入SQL.txt");
        File f3 = new File(d, "test2.java");
        File d2 = new File(d, "aa/bb/cc/dd");
        try {
            f3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f3.delete();

        //创建多级目录，需要使用mkdirs()，而不是mkdir()
        d2.mkdirs();
        //d2.delete()方法删除的是最下级的目录dd，如果要删除所有级别的目录，需要自己写实现，File类不提供方法。
        d2.delete();

        System.out.println("File is:\t\t" + f.toString());
        System.out.println("File is exist:\t\t" + f.exists());
        System.out.println("File can read:\t\t" + f.canRead());
        System.out.println("File can write:\t\t" + f.canWrite());
        System.out.println("File can execute:\t\t" + f.canExecute());

        /**
         * lastModified()方法返回一个long型，表示文件的最后修改时间。
         * 将该方法返回的值作为Date构造器函数的参数传入，得到可读的日期。
         */
        Date date = new Date(f.lastModified());
        System.out.println(date);

        /*
        如果一个File对象指向的文件不存在，那么当判断其为文件还是文件夹时，结果都是false。
         */
        File noFile = new File("/Users/cashlu/Desktop/11111.txt");
        System.out.println(noFile.isFile());
        System.out.println(noFile.isDirectory());
        //文件的大小
        System.out.println(f2.length());

    }
}
