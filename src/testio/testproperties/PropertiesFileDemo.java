package testio.testproperties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * 从指定的配置文件中读取键值对。
 * <p/>
 * 1、用读取流来读取文件。
 * 2、每次读取一行，用"="来切割读取到的字符串
 * 3、将分割后的字符串分别做为键值存入Properties集合中。
 * Created by cashlu on 15/4/17.
 */
public class PropertiesFileDemo {
    public static void main(String[] args) {
        File proFile = new File("/Users/cashlu/Desktop/properties.txt");
        Properties properties = new Properties();
//        fileToProp(proFile, properties);
        loadFile(properties, proFile);
//        printProperties(properties);
        //列出Properties集合中的键值对
        properties.list(System.out);
        properties.setProperty("王五", "60");
        properties.list(System.out);
        modifyFile(proFile, properties);
        Integer c = new Integer(properties.getProperty("王五"));
        System.out.println(c);
    }

    /**
     * 使用Properties自带的load()方法读取配置文件，将配置文件中的键值对保存至Properties集合中。
     *
     * @param properties 保存键值对的Properties对象。
     * @param file       读取的配置文件。
     * @return 返回保存键值对之后的Properties对象。
     */
    public static Properties loadFile(Properties properties, File file) {
        BufferedInputStream bis = null;
        BufferedReader br = null;
        try {
//            //load()方法要求传入的参数是一个InputStream或者Reader对象。
            //区别在于load(FileReader)方法不用考虑字符编码问题。
//            bis = new BufferedInputStream(new FileInputStream(file));
//            properties.load(bis);


            br = new BufferedReader(new FileReader(file));
            properties.load(br);


            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 读取配置文件，并将读取到的键值对存储进Properties集合对象中。
     *
     * @param file       配置文件
     * @param properties 要存储的Properties对象。
     */
    public static void fileToProp(File file, Properties properties) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] str = line.split("=");
                properties.setProperty(str[0], str[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 遍历Properties集合对象，在控制台打印键值对。
     *
     * @param properties 需要遍历打印的Properties对象。
     */
    public static void printProperties(Properties properties) {
        Set<String> keySet = properties.stringPropertyNames();
        for (String s : keySet)
            System.out.println(s + " : " + properties.getProperty(s));
    }


    /**
     * 更改配置文件的方法。如果Properties对象中存储的键值对发生变化，那么需要同步更新到配置文件中。
     * 使用Properties对象的store()方法来实现。需要传入一个OutputStream对象，也可以用Writer对象。
     * @param file 配置文件
     * @param properties Properties对象
     */
    public static void modifyFile(File file, Properties properties) {
        BufferedOutputStream bos = null;
        BufferedWriter bw = null;
        try {
//            bos = new BufferedOutputStream(new FileOutputStream(file));
//            properties.store(bos, "hh");
            bw = new BufferedWriter(new FileWriter(file));
            properties.store(bw, "Comments...");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

