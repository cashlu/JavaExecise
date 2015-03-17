package testThread.testJoinYieldSleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cashlu on 15/2/27.
 */
public class SleepDemo {
    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis() + 10000);
        long end = endTime.getTime();
        System.out.println("当前时间" + new SimpleDateFormat("mm:ss").format(new Date()));
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            //构建下一秒的时间
            endTime = new Date(endTime.getTime() - 1000);
            Thread.sleep(1000);
            if (end - 10000 > endTime.getTime()){
                break;
            }
        }

    }
}
