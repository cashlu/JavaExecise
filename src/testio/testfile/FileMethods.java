package testio.testfile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的常用方法：
 * 1、创建
 * 2、删除
 * 3、判断
 * 4、获取信息
 * Created by cashlu on 15/4/13.
 */
public class FileMethods {
    public static void main(String[] args) throws IOException {
        //创建文件，返回boolean型，表示是否创建成功。文件已存在则不创建，返回false。
        File f1 = new File("/Users/cashlu/Desktop/f1.txt");
        boolean f1Create = f1.createNewFile();
        System.out.println(f1Create);

        //删除文件
        File f2 = new File("/Users/cashlu/Desktop/f2.txt");
        f2.createNewFile();
        boolean f2Delete = f2.delete();
        System.out.println(f2Delete);

        //在程序退出时执行删除，所以输出f1的存在状态为true
        f1.deleteOnExit();
        System.out.println(f1.exists());

        //判断是否存在，是否是文件，是否是文件夹
        File f3 = new File("/Users/cashlu/Desktop/f3.txt");
        File f4 = new File("/Users/cashlu/Desktop/f4.txt");
        File f5 = new File("f5.txt");
        f3.createNewFile();
        f4.mkdir();

        System.out.println("f3:\t是否存在：" + f3.exists() + "\t是否文件：" + f3.isFile() + "\t是否目录：" + f3.isDirectory());
        System.out.println("f4:\t是否存在：" + f4.exists() + "\t是否文件：" + f4.isFile() + "\t是否目录：" + f4.isDirectory());
        System.out.println("f5:\t是否存在：" + f5.exists() + "\t是否文件：" + f5.isFile() + "\t是否目录：" + f5.isDirectory());

        //获取文件信息
        System.out.println("getName()\t" + f3.getName());
        System.out.println("getPath()\t" + f3.getPath());
        System.out.println("getParent()\t" + f3.getParent());
        System.out.println("getAbsolutePath()\t" + f5.getAbsolutePath());
        System.out.println("getTotalSpace()\t" + f3.getTotalSpace());
        System.out.println("lastModified()\t" + new Date(f3.lastModified()));

    }
}
