package testio.testsequenceInputstream;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by cashlu on 15/4/24.
 */
public class SequenceDemoWithBuff {
    public static void main(String[] args) {
        Vector<BufferedInputStream> v = new Vector<BufferedInputStream>();
        SequenceInputStream sis = null;
        BufferedOutputStream bos = null;
        try {
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/1.txt")));
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/2.txt")));
            v.add(new BufferedInputStream(new FileInputStream("/Users/cashlu/Desktop/3.txt")));

            Enumeration<BufferedInputStream> en = v.elements();
            sis = new SequenceInputStream(en);
            bos = new BufferedOutputStream(new FileOutputStream("/Users/cashlu/Desktop/4.txt"));

            int by = 0;
            while ((by = sis.read()) != -1) {
                bos.write(by);
            }

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


}
