package testException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by cashlu on 14/11/29.
 */
public class TestManualThrowException {
    public static void main(String[] args) {
        File f = new File("/Users/cashlu/Desktop/ttt");
        if (!f.exists()){
            try {
                throw new FileNotFoundException("File is not exists!!!!!!!!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
