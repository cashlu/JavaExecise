package testio.testfile;

import java.io.File;

/**
 * Created by cashlu on 14/11/27.
 */
public class FilesTree {
    public static void main(String[] args) {
        File file = new File("/Users/cashlu/Desktop");
        printFileTree(file, 0);
    }

    /**
     * printFileTree()方法的作用是打印目录树结构
     * 这个方法是static方法，因为需要在创建FilesTree对象之前就可以调用，也就是说这个程序不需要创建一个FilesTree对象
     * @param file 一个File对象，可以是一个文件或者目录
     * @param level 该File对象的目录级别，顶级为0，一开始传入0，每递归一次后+1
     */
    static void printFileTree(File file, int level){
        //在文件名前打印"-"，处于第几级，就打印几个
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        //"-"后跟着打印文件名
        System.out.println(" " + file.getName());

        /**
         * 判断方法传入的File对象是否为目录，如果是的话，则将该目录下的所有目录或者文件传入到一个数组中，
         * 然后遍历数组，将数组中所有的元素依次作为printFileTree()方法的参数，再次执行printFileTree()方法。
         * 方法内部调用方法自身，这就是所谓的“递归”
         */
        if (file.isDirectory()){
            File files[] = file.listFiles();
            for(File f: files){
                printFileTree(f, level + 1);
            }
        }
    }
}
