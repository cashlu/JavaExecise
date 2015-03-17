package testDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化的日历
 * Created by cashlu on 14/11/25.
 */
//public class VisualCalendar {
//    public static void main(String[] args) {
//
//        System.out.println("请输入日期（格式：2014-3-20）");
//        Scanner scanner = new Scanner(System.in);
//        String inputDate = scanner.nextLine();
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date = format.parse(inputDate);
//            GregorianCalendar calendar = new GregorianCalendar();
//            //setTime()方法要求传入Date对象，这一点与set()方法不同
//            calendar.setTime(date);
//            //保存一下指定的日期，因为后面需要将日期暂时设置为1
//            int day = calendar.get(Calendar.DATE);
//            //判断指定的日期是星期几，计算结果需要-1，因为周天是一周的开始，周天是1
//            System.out.println(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DATE) + "日是星期" + (calendar.get(Calendar.DAY_OF_WEEK) - 1));
//            //将日期设置为1号，用于判断1号是星期几，以便正确的显示
//            calendar.set(Calendar.DATE, 1);
//            //判断2014-1这个月有多少天
//            int maxDate = calendar.getActualMaximum(Calendar.DATE);
//            System.out.println(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月有" + maxDate + "天");
//            System.out.println("日\t\t一\t\t二\t\t三\t\t四\t\t五\t\t六");
//
//            //1号的显示应该对应在相应的星期几下面，所以前面都要输出\t\t
//            for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
//                System.out.print("\t\t");
//            }
//
//            //开始循环显示日期
//            for (int i = 1; i <= maxDate; i++) {
//                //指定日期加*来标注
//                if (i == day) {
//                    System.out.print("*" + i + "\t\t");
//                } else {
//                    System.out.print(i + "\t\t");
//                }
//                //判断本次循环的日期是否是星期六，如果是的话，那么加一次换行
//                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//                if (dayOfWeek == Calendar.SATURDAY) {
//                    System.out.println();
//                }
//                //一个循环结束，日期+1
//                calendar.add(Calendar.DATE, 1);
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//}


public class VisualCalendar {
    public static void main(String[] args) {
        System.out.println("请输入日期（格式：2014-11-22）");
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = new Date();
            date = format.parse(inputDate);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int dayOfMonth = calendar.get(Calendar.DATE);
            calendar.set(Calendar.DATE, 1);
            int maxDate = calendar.getActualMaximum(Calendar.DATE);

            System.out.println("日\t\t一\t\t二\t\t三\t\t四\t\t五\t\t六");
            for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
                System.out.print("\t\t");
            }

            for (int i = 1; i <= maxDate; i++) {
                if (i == dayOfMonth) {
                    System.out.print("*" + i + "\t\t");
                } else {
                    System.out.print(i + "\t\t");
                }

                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                    System.out.println();
                }
                calendar.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


















