package testio.testproperties;

import java.io.*;
import java.util.Properties;

/**
 * 模拟共享软件，程序可运行5次，5次后提醒用户注册付费。
 * 思路：使用Properties文件来记录程序运行的次数。
 * Created by cashlu on 15/4/19.
 */
public class SoftwareRegRemind {
    public static void main(String[] args) {
        File profile = new File("/Users/cashlu/Desktop/prop.txt");
        int limit = 5;
        run(limit, profile);

    }

    /**
     * 模拟程序运行的方法。程序每次运行5秒钟，然后自动结束。
     * 先调用compareCount()方法来判断是否可继续使用。
     */
    public static void run(int limit, File file) {
        File profile = file;
        int compareRes[] = compareCount(limit, file);
        if (compareRes[0] == 1) {
            System.out.println("剩余试用次数：" + compareRes[1]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("程序开始运行了...");
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("程序结束运行...");
        } else {
            System.out.println("剩余试用次数：" + compareRes[1]);
            System.out.println("请购买使用，谢谢！");
        }
    }

    /**
     * 操作配置文件的方法，用于判断软件的试用次数是否耗尽。
     * 1、判断配置文件是否存在，如果不存在，则说明软件是第一次运行，创建配置文件，试用次数为limit-1。如果存在，则执行下面的步骤。
     * 2、判断使用次数是否到0，如果没有，则使用次数-1，并返回true(1)和次数，并将新的次数写入配置文件。
     * 3、如果试用次数到0，则返回false(0)和次数。
     *
     * @param limit   软件可试用的次数。
     * @param profile 记录试用次数的配置文件
     * @return 是否可继续使用，剩余使用次数的int数组。1可使用，0不可使用。
     */
    public static int[] compareCount(Integer limit, File profile) {
        Properties properties = new Properties();
        BufferedReader br = null;
        BufferedWriter bw = null;
        int[] res = new int[2];
        Integer count;
        if (profile.exists()) {
            try {
                br = new BufferedReader(new FileReader(profile));
                properties.load(br);
                count = new Integer(properties.getProperty("use_count"));
                if (count > 0) {
                    properties.setProperty("use_count", (--count).toString());
                    bw = new BufferedWriter(new FileWriter(profile));
                    properties.store(bw, "试用次数");
                    res[0] = 1;
                    res[1] = count;
                    return res;
                } else {
                    res[0] = 0;
                    res[1] = count;
                    return res;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (br != null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            try {
                profile.createNewFile();
                bw = new BufferedWriter(new FileWriter(profile));
                properties.setProperty("use_count", (--limit).toString());
                properties.store(bw, "剩余试用次数");
                res[0] = 1;
                res[1] = limit;

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }

}
