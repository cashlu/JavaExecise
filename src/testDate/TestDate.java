package testDate;


import java.util.Date;

/**
 * Date类的用法
 * Date类中对时间的表示，是从1970年1月1日0点开始计算，与此时间相距的微秒数。
 * Created by cashlu on 14/11/21.
 *
 */


public class TestDate {
    public static void main(String[] args) {
        //创建对象d时没有参数，所以为默认值为当前时区的时刻
        Date d = new Date();
        //返回当前时间距1979-1-1：00：00：00的微妙值
        long t = System.currentTimeMillis();
        //对象d1代表距离1979-1-1：00：00：00增加2000毫秒的时间
        //需要注意的是这里计算时，采用了CST时间，而不是GMT时间
        Date d1 = new Date(2000);
        System.out.println(t);
        System.out.println(d);
        System.out.println(d1);

        Date d3 = new Date();
        Date d4 = new Date();
        d3.setTime(1000);
        d4.setTime(2000);
        System.out.println("d3 = " + d3.getTime());
        System.out.println("d4 = " + d4.getTime());
        System.out.println("d3.before(d4) : " + d3.before(d4));
        System.out.println("d4.after(d3) : " + d4.after(d3));

    }

}
