package testDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * DateFormat类的使用
 * Created by cashlu on 14/11/21.
 */
public class testDateFormat {
    public static void main(String[] args){
        /**
         * 格式化显示时间
         * DateFormat是抽象类，SimpleDateFormat是DateFormat的子类
         *
         * 对象df是是SimpleDateFormat的对象，df是格式化显示时间的模板，在格式化时间时，需要调用format()方法。
         */

        //定义格式化模板
        SimpleDateFormat df = new SimpleDateFormat("y-MM-dd HH:mm:ss,是本年的第w周,本月的第W周");
        //创建当前时间的对象now
        Date now = new Date();
        //创建一个Date对象，距离1979年1月1日0点1295009990000微秒
        Date d = new Date(1295009990000L);
        String str = df.format(d);
        System.out.println(str);
        System.out.println(df.format(now));

        /**
         * 将字符串转化为Date对象
         *
         */
        String date = "2014-11-11";
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        //这里必须捕获异常，判断字符串是否可以被转换，貌似是JAVA语法的规定，暂时还没搞清楚为什么
        try {
            Date dd = df2.parse(date);
            System.out.println(dd);
            System.out.println(df.format(dd));

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
