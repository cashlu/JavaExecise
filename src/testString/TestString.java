package testString;

/**
 * Created by cashlu on 14/11/11.
 */
public class TestString {
    public static void main(String[] args) {

        //创建String对象的三种方式
        String str1 ="str1";
        String str2 = new String("str1");
        char c[] = {'s', 't', 'r', '3'};
        String str3 = new String(c);

        System.out.println(str1 + ":\t" + str1.getClass());
        System.out.println(str2 + ":\t" + str2.getClass());
        System.out.println(str3 + ":\t" + str3.getClass());

        //测试String的replace()方法
        String strOld = "Nice to meet you Simon";
        String strNew;
        strNew = strOld.replace("Simon", "Jean");
        System.out.println(strNew);

        /**
         * 测试字符串比较的两种方法：==和equals()
         * equals()方法比较是两个字符串的内容，详细参考equals()方法的源代码
         * equalsIgnoreCase()方法是比较字符串，忽略大小写的区别。
         *
         * strA == strB是因为这两个变量是都指向了常量池中的“Hello”，字符串常量是在编译器就产生的。
         * strA != strC是因为strC是一个String对象，String对象是在程序运行期生成，并存储在堆内存中，所以不相等。
         *
         * strA == strD是因为"He"和"llo"都是字符串常量，两个字符串常量拼接得来的肯定还是字符串常量，程序在编译期，
         * 先计算"He" + "llo",得到一个字符串常量"Hello"，然后查看常量池中是否有这个常量，有的话直接将strD指向该常量，
         * 没有的话就先创建，再指向。这里需要注意的是，常量池中的常量，都是唯一的，相同的只存储一遍，然后被多个变量指向。
         */
        String strA = "Hello";
        String strB = "Hello";
        String strC = new String("Hello");
        String strD = "He" + "llo";
        String strE = "hello";

        System.out.println("strA.equals(strB):\t" + strA.equals(strB));
        System.out.println("strA == strB:\t" + (strA == strB));

        System.out.println("strA == strB:\t" + (strA == strB));     //true
        System.out.println("strA == strC:\t" + (strA == strC));     //false
        System.out.println("strA == strD:\t" + (strA == strD));     //true

        System.out.println("strA.equalsIgnoreCase(strE):\t" + strA.equalsIgnoreCase(strE));

        /**
         * 测试String切割字符串方法split()
         * @param ""  参数传入分割的界限
         * @return String[] 返回一个字符串数组
         */

        String strFull1 = "aaa,bbb,ccc";
        String strFull2 = "nice to meet you";
        String strFull1_s[] = strFull1.split(",");
        String strFull2_s[] = strFull2.split(" ");

        for(int i = 0; i < strFull1_s.length; i++){
            System.out.print(strFull1_s[i] + "\t");
        }
        System.out.println();

        for(int i = 0; i < strFull2_s.length; i++){
            System.out.print(strFull2_s[i] + "\t");
        }
        System.out.println();

        /**
         * 测试String.trim()方法，用于去除字符串首位的空格
         * @return 返回一个新的String对象
          */

        String strWithSpace = "  aa  bb  cc  ";
        System.out.println(strWithSpace.trim());

        /**
         * 测试String.toCharArray()方法，用于将字符串拆分成字符数组
         * @return 返回一个新的char[]数组对象
         */
        char res[];
        res = strA.toCharArray();
        for(char ch: res){
            System.out.print(ch + "\t");
        }
        System.out.println();

        /**
         * 测试indexOf()方法，用于返回某char在String中的index。
         * @return 返回一个int，代表该字符在String对象中的下标。如果查找的char在String对象中不是唯一，那么返回第一个的index。
         */

        System.out.println("strA.indexOf('l'):\t" + strA.indexOf('l'));
        System.out.println();

        /**
         * 测试startWith()和endWith()方法。
         * @param String 传入一个String对象的参数。判断是否由该字符串开头或结束。
         * @rentun boolean
         */

        System.out.println("strA.startsWith(\"He\"):\t" + strA.startsWith("He"));
        System.out.println("strA.endsWith(\"llo\")" + strA.endsWith("llo"));


    }
}
