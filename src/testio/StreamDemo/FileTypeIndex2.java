package testio.StreamDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 产生指定文件类型索引文件的第二版实现。
 * 结构更清晰，将实现拆分为两个方法：
 * fileToList()将索引结果存储至List<File>集合中，使用到了集合与泛型。
 * writeToFile()将集合中的结果写入文件，使用了缓冲IO流。
 *
 *
 * Created by cashlu on 15/4/17.
 */
public class FileTypeIndex2 {
    public static void main(String[] args) {
        File searchRoot = new File("/Users/cashlu/Desktop");
        File resFile = new File("/Users/cashlu/Desktop/list.txt");
        List<File> fileList = new ArrayList<File>();
        fileToList(searchRoot, fileList, ".txt");
        for (File f : fileList){
            System.out.println(f.getAbsolutePath());
        }
        try {
            writeToFile(fileList, resFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void fileToList(File dir, List<File> list, String type){
        File files[] = dir.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                fileToList(file, list, type);
            }
            else{
                if (file.getName().endsWith(type)){
                    list.add(file);
                }
            }
        }
    }

    public static void writeToFile(List<File> list, File listFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(listFile));
        for (File f : list){
            bw.write(f.getAbsolutePath());
            bw.newLine();
        }
        bw.close();
    }
}
