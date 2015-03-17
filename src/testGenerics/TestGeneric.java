package testGenerics;

/**
 * 泛型的测试
 * Created by cashlu on 15/2/1.
 */
public class TestGeneric {
    public static void main(String[] args) {
        StudentForGen<String, Integer> stu1 = new StudentForGen<String, Integer>();
        //不同于多态，泛型会做自动的类型检查，所以不需要强制类型转换。
        stu1.setJavaScore("A");
        stu1.setOracleScore(80);
        Integer oracleS = stu1.getOracleScore();
        //直接用基本类型int也行，因为会“自动拆箱”
        int oracleS2 = stu1.getOracleScore();


    }
}
