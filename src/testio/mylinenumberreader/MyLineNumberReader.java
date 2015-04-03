package testio.mylinenumberreader;

import java.io.FileReader;
import java.io.IOException;

/**
 * 自己实现一个类似于LineNumberReader的类。
 * Created by cashlu on 15/4/2.
 */
public class MyLineNumberReader {
    private FileReader fr;
    private int lineNum = 0;
    private int ch = 0;

    public MyLineNumberReader(FileReader fr) {
        this.fr = fr;
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        lineNum++;
        while ((ch = fr.read()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n') {
                lineNum++;
                return sb.toString();
            } else {
                sb.append((char) ch);
            }
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        return null;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public void close() {
        try {
            if (fr != null)
                fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
