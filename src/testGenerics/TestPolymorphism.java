package testGenerics;

/**
 * 这个类运用了多态，目的是和泛型相比较。
 * 具体的泛型实现方式，参考另一个类。
 * Created by cashlu on 15/2/1.
 */
public class TestPolymorphism {
    public static void main(String[] args) {
        //先使用多态来创建对象

        //int型
        //这里会“自动装箱”: int -> Integer -> Object
        StudentForPolymorphism stuInt = new StudentForPolymorphism(80, 90);
        //获取需要强制类型转换,最好手动做类型检查，避免ClassCastException异常。
        //这里举一个例子，后面就不做了。
        //也可以用异常来处理。
        if (stuInt.getJavase() instanceof Integer) {
            int stuIntJ = (Integer) stuInt.getJavase();
        }
        int stuIntO = (Integer) stuInt.getOracle();


        //double型
        StudentForPolymorphism stuDouble = new StudentForPolymorphism(80.82, 90.92);
        double stuDoubleJ = (Integer) stuDouble.getJavase();
        double stuDoubleO = (Integer) stuDouble.getOracle();


        //String型
        StudentForPolymorphism stuString = new StudentForPolymorphism("B", "A");
        String stuStringJ = (String) stuString.getJavase();
        String stuStringO = (String) stuString.getOracle();

    }
}
