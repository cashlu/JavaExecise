package testWrapperClass;

/**
 * 包装类
 * 包装类的作用是将普通数据类型包装为对象，从而可以使用对象的一些特性
 * Created by cashlu on 14/11/21.
 */
public class TestWrapperClass {
    public static void main(String[] args) {
        Integer a = new Integer(1000);
        int b = 2000;

        //打印Integer对象的最大值和最小值
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //字符串转换为Integer
        String str = "123";
        Integer c = Integer.parseInt(str);
        Integer d = new Integer("345");
        System.out.println(c.getClass());
        System.out.println(d.getClass());

        //Integer对象转换为int
        int f = d.intValue();
        System.out.println(f);

    }
}


