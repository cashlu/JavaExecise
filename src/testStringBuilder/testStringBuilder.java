package testStringBuilder;

/**
 * 测试可变字符序列：StringBuilder、StringBuffer
 * StringBuilder：线程不安全，效率高
 * StringBuffer：线程安全，效率低
 *
 * Created by cashlu on 14/11/12.
 */
public class testStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("abcd");
        StringBuilder sb3 = new StringBuilder("abcdefghijklmnopqrstuvwxyz");

        /**
         * 测试append()方法
         * 向字符串对象追加字符串，String类没有这个方法，因为String类是不可变字符串
         * @param StringBuilder 需要追加的字符串
         * @return StringBuilder 返回修改后的字符串
         *
         */
        sb2.append("efg");
        System.out.println(sb2);
        System.out.println(sb2.getClass());

        /**
         * 测试StringBuilder的一些其他常用方法
         */

        sb3.delete(3, 5).delete(3, 5);      //删除特定字符（包头不包尾）
        System.out.println(sb3);
        System.out.println(sb3.reverse());      //反转字符串



    }
}


