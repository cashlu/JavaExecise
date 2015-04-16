package testio.testfile;

import java.io.File;

/**
 * 列出指定File对象下的文件及目录列表。主要使用的技术是递归。
 * 递归是在方法体内调用自身的一种技术。
 *
 * Created by cashlu on 15/4/16.
 */
public class FileLIstAll {
    static int count = 0;
    public static void main(String[] args) {
        File dir = new File("/Users/cashlu/Desktop/郑春艳考试");
        listAllFileWithLevel(dir, 0);
    }

    /**
     * 列出dir下所有的文件及目录，不分级。
     * @param dir
     */
    public static void listAllFile(File dir) {
        File files[] = dir.listFiles();
        for (File file : files) {
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            }
            if (file.isDirectory()){
                System.out.println(file.getAbsolutePath());
                listAllFile(file);
            }
        }
    }

    /**
     * 列出file对象下的所有目录及文件，分级显示。
     * @param file File对象，是一个目录。
     * @param level 表示该对象的级别，默认是0，每一级都是上一级的level-1。
     */
    public static void listAllFileWithLevel(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
        System.out.print("|-");
        System.out.println(file.getName());

        if (file.isDirectory()){
            File f[] = file.listFiles();
            for (File name : f){
                listAllFileWithLevel(name, level++);
            }
        }
    }
}
