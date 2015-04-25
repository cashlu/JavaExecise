package testio.testsequenceInputstream;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 文件的切割。
 * Created by cashlu on 15/4/24.
 */
public class SplitFile {
    public static void main(String[] args) {
        File splitSrc = new File("/Users/cashlu/Desktop/pic.jpg");
        File splitDestDir = new File("/Users/cashlu/Desktop/pics/");
        try {
            splitFile(splitSrc, splitDestDir);
        } catch (IOException e) {
            e.printStackTrace();
        }


        File joinDestFile = new File("/Users/cashlu/Desktop/pics/pic.jpg");
        Vector<BufferedInputStream> v = new Vector<BufferedInputStream>();
        joinFiles(v, joinDestFile);

    }

    /**
     * 文件的合并方法。
     *
     * @param v            被合并文件的Vector集合封装对象。
     * @param joinDestFile 合并后的目的地对象。
     */
    public static void joinFiles(Vector<BufferedInputStream> v, File joinDestFile) {
        SequenceInputStream sis = null;
        BufferedOutputStream bos = null;
        try {
            /*
                因为分割文件时，是按字节读取一定量后截取的，所以在合并时，是顺序敏感的。
                而Vector是有序集合（比起ArrayList线程安全），刚好可以按照顺序保存每一个文件片段。
                所以当Vector对象在add时，顺序一定要正确。

                Vector虽然线程安全，但是效率较低，所以在不考虑多线程操作的情况下，可以使用ArrayList来代替。
                但是ArrayList没有枚举，只有迭代。所以要用迭代器获取元素，然后用枚举封装，重写hasMoreElement()
                和nextElement()方法 。
             */
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/pics/0.part")));
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/pics/1.part")));
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/pics/2.part")));
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/pics/3.part")));
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/pics/4.part")));

            Enumeration<BufferedInputStream> en = v.elements();
            sis = new SequenceInputStream(en);
            bos = new BufferedOutputStream(new FileOutputStream(joinDestFile));
            int by = 0;
            while ((by = sis.read()) != -1) {
                bos.write(by);
            }
            System.out.println("合并文件完成...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sis != null) {
                try {
                    sis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件的分割方法。
     *
     * @param src     要分割的源文件。
     * @param destDir 分割后分卷文件存放的目录。
     * @throws IOException
     */
    public static void splitFile(File src, File destDir) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = null;
        //创建一个1M的缓冲区，将文件按照1M的大小进行切割。
        byte buf[] = new byte[1024 * 1024];
        int len = 0;
        int fileName = 0;
        while ((len = fis.read(buf)) != -1) {
            fos = new FileOutputStream(destDir.getPath() + "/" + fileName++ + ".part");
            fos.write(buf, 0, len);
            fos.close();
        }
        fis.close();
    }
}
