package testio.testfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 在指定目录下层级查找指定类型的文件，并将结果输出到一个文本文件中。
 * Created by cashlu on 15/4/16.
 */
public class FileTypeIndex {
    static StringBuilder listTmp = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        File root = new File("/Users/cashlu/IdeaProjects");
        File res = new File("/Users/cashlu/Desktop/res.txt");
        fileList(root, ".java");
        System.out.println("文件数：" + count);
        System.out.println(listTmp.toString());
        BufferedWriter bw = new BufferedWriter(new FileWriter(res));
        bw.write("文件数：" + count + "\n");
        bw.write(listTmp.toString());
        bw.close();

    }

    public static void fileList(File searchRoot, String type) {
        File files[] = searchRoot.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(type)) {
                listTmp.append(f.getAbsoluteFile() + "\n");
                count++;
            }
            if (f.isDirectory()) {
                fileList(f, type);
            }
        }
    }

}
