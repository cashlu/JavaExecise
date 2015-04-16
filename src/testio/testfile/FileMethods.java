package testio.testfile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
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

        File list[] = File.listRoots();
        for (File f : list) {
            System.out.println(f);
        }

        System.out.println("-------------");

        File d = new File("/Users/cashlu");
        String[] names = d.list();
        for (String name : names)
            System.out.println(name + "\t");

        System.out.println("-------------");
        listFilenameFilteDemo();

        System.out.println("makeDirWithFiles()-------------");
        makeDirWithFiles();
        File dir = new File("/Users/cashlu/Desktop/aaa/");
        delNoneEmptyDIr(dir);


    }

    /**
     * 打印指定目录下指定后缀的文件，目录忽略。
     * 测试File.listFile(FileFilter)方法。
     * 该方法要求传入的形参是FileFilter对象。
     */
    public static void listFileFilterDemo() {
        File txtD = new File("/Users/cashlu/Desktop");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile() == true)
                    return pathname.getPath().endsWith(".txt");
                else
                    return false;
            }
        };
        File[] files = txtD.listFiles(filter);
        for (File f : files)
            System.out.println(f.getAbsolutePath());
    }

    /**
     * 打印指定目录下指定后缀的文件，目录忽略。
     * 测试File.listFile(FileNameFilter)方法。
     * 该方法要求传入的形参是FileNameFilter对象。
     */
    public static void listFilenameFilteDemo() {
        System.out.println("listFileFilterDemo()...");
        File txtD = new File("/Users/cashlu/Desktop");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };
        String docs[] = txtD.list(filter);
        for (String name : docs)
            System.out.println(name + "\t");
        System.out.println("-----------------");
    }

    /**
     * 删除一个带有内容的多级目录。
     * 1、先创建文件对象
     * 2、创建目录
     * 3、创建文件
     * 4、删除文件
     * 5、删除目录
     */

    public static void makeDirWithFiles() throws IOException {
        File file = new File("/Users/cashlu/Desktop/aaa/bbb/ccc/abc.txt");
        boolean makeDirsRes = file.getParentFile().mkdirs();
        boolean fileCreateRes = file.createNewFile();
        System.out.println("文件名称:\t" + file.getAbsolutePath() + "\n"
                + "目录创建结果:\t" + makeDirsRes + "\n"
                + "文件创建结果:\t" + fileCreateRes);
    }


    /**
     * 删除一个非空的多级目录。
     * 因为要多级遍历，所以使用到了递归。
     * <p/>
     * 作为传输传入的dir，必须是一个目录，如果不是目录的话，listFiles()方法会返回null,
     * 那么在for循环遍历的时候，会抛出空指针异常。
     *
     * @param dir 需要删除的目录。
     */
    public static void delNoneEmptyDIr(File dir) {
        File files[] = dir.listFiles();
        for (File file : files) {
            //遍历数组，如果元素是目录，则递归。
            if (file.isDirectory()) {
                delNoneEmptyDIr(file);
            } else {
                System.out.println("删除文件：" + file.delete() + "\t" + file.getAbsolutePath());
            }
        }
        System.out.println("删除目录：" + dir.delete() + "\t" + dir.getAbsolutePath());
    }

}
