package testio.testrandomaccessfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by cashlu on 15/4/28.
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        File file = new File("/Users/cashlu/Desktop/test.txt");
        writeFile(file, "芦满");

        readFile(file);
    }

    public static void readFile(File file){
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            byte[] buf = new byte[8];
            raf.read(buf);
            System.out.println(new String(buf));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(File file, String str){
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.write(str.getBytes());
//            raf.skipBytes(8*2);
            raf.seek(8*8);
            raf.write(str.getBytes());
//            raf.writeUTF("芦满");
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
