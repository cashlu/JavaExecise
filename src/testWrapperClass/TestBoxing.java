package testWrapperClass;

/**
 * 自动装箱，拆箱（Auto-Boxing/unboxing）
 * Created by cashlu on 14/11/21.
 */
public class TestBoxing {
    public static void main(String[] args) {
        /**
         * 装箱（Boxing）
         * 下面的语法是JDK5支持的新特性。左边为Integer的引用，右边是一个int。实际上编译器会将代码自动转换为如下形式：
         * Integer a = new Ingeter(1000);
         */
        Integer a = 1000;
        System.out.println(a.getClass());

        /**
         * 拆箱(unboxing)
         * 下面的语法是JDK5支持的新特性。左边为int类型，右边引用的是一个Integer对象。实际上编译器会将代码自动转换为如下形式：
         * int b = new Integer(1000).ValueOf() ;
         */
        int b = new Integer(1000);


        /**
         * 下面是对象比较的一个问题
         * a1 == a2为false，是因为==运算符比较的是两个引用的内存地址，这里明显是new了两个不同的Integer对象，地址当然不同。
         * a1.equals(a2)为true，可以查看equals()方法的代码，这里比较的是两个对象的valueOf()，所以是相等的。
         *
         * b1 == b2为true，但是a1 == a2为false，查看Integer.ValueOf()代码，其实JAVA对-128~127范围的int进行了缓存，
         * 所以b1 == b2时，虽然比较的是引用的地址，但实际上b1和b2都引用了同一个内存地址，所以返回true。
         *
         * 这就是为什么相同的方法，不同的数字，比较返回不同结果的原因了。
         *
         */

        System.out.println("################");
        Integer a1 = 200;
        Integer a2 = 200;
        System.out.println(a1 == a2);       //false
        System.out.println(a1.equals(a2));      //true

        System.out.println("################");
        Integer b1 = 100;
        Integer b2 = 100;
        System.out.println(b1 == b2);       //true
        System.out.println(a1.equals(a2));      //true



    }
}
