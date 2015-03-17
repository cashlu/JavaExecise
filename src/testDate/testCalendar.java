package testDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试Calendar类
 * Calendar类是抽象类，具体实现可使用其子类GregorianCalendar
 * Calendar计算月份时，一月是0
 * Calendar计算星期时，周天是0
 *
 * Created by cashlu on 14/11/25.
 */
public class testCalendar {
    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar();
        /**
         * 使用getTime()方法来获取时间
         * 当创建GregorianCalendar对象时没有传入参数，那么该对象代表当前时刻
         */


        System.out.println(birthday.getTime());
        //  set()方法传入int型参数，设置时间
        birthday.set(1984, 0, 7, 8, 45);
        System.out.println(birthday.getTime());

        //  创建一个Date对象，以便于使用SimpleDateFormat类的方法来格式化时间的显示
        //  getTime()方法返回一个Date对象，来表示this对象代表的时间
        //  吐槽一下：难道就不能给Calendar类专门写一个格式化的方法吗？非要去调用SimpleDateFormat类的方法
        Date d = birthday.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(d));

        GregorianCalendar c = new GregorianCalendar();
        //  setTime()方法传入Date型对象，设置时间
        //  查看Date类的构造器函数代码，传入的第一个参数年份是相对于历元（1900年）的偏移量
        //  吐槽一下：这个鸡巴构造器函数是谁写的？难道就不能直接传入年份吗？和月、日的行为不一致！！！难道就没有直接一点的类或者方法吗？
        c.setTime(new Date(84, GregorianCalendar.JANUARY, 7));
        System.out.println(c.getTime());
        c.add(Calendar.YEAR, 30);
        System.out.println(c.getTime());
        System.out.println(c);
    }
}
