package testio.mybufferedreader;

import java.io.FileReader;
import java.io.IOException;

/**
 * 自己实现一个BufferedReader的功能。
 * Created by cashlu on 15/3/30.
 */
public class MyBufferedReader {
    private FileReader fr;
    public MyBufferedReader(FileReader fr) {
        this.fr = fr;
    }

    /**
     * 读取文件一行的方法，遇到换行符则停止，并返回读取到的这一行。
     * 如果读到的第一个字符就是换行符，那么视为一个空行，直接返回空。
     * JDK的实现用的是字符数组，这里为了方便，用的是StringBuilder对象，
     * 实际上StringBuilder底层实现还是字符数组。直接用字符数组性能是最优的。
     *
     * @return 返回空或者一个String对象。
     * @throws IOException
     */
    public String myReadLine() throws IOException {
        //定义一个存放缓存的容器，暂时先用StringBuilder，以后改为字符数组
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n'){
                return sb.toString();
            }
            else
                //这里千万记住要强转，因为之前将ch定义为int了，不转的话，返回的是文字的字符集编码。
                sb.append((char)ch);
        }
        //如果文件最后一行没有换行符，但是有数据，如果不判断长度，会丢掉最后一行。
        if (sb.length() != 0)
            return sb.toString();
        return null;
    }

    /**
     * 资源的关闭方法。定义该方法关闭资源，并处理异常，那么在使用MyBufferedReader对象时，
     * 就不需要重复关闭缓冲及FileReader对象资源了。
     */
    public void close() {
        try {
            if (fr != null)
                fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
