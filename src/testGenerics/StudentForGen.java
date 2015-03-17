package testGenerics;

/**
 *  这是一个泛型类。注意泛型类的文件名没有"<T>"。
 * 泛型使用时的注意事项：
 * 1、只能使用引用类型，不能使用基本类型，也就是说尖括号里不能出现类似于int等基本类型。
 * 2、泛型申明时不能使用static关键字。因为静态类型是在编译期生成，但是泛型需要到运行期才能确定类型。
 * Created by cashlu on 15/2/1.
 */

/*
类声明时，尖括号中的T并不是定死的。可以是任意字符。只不过一般的约定如下：
T: 表示类型（Type）
K, V: 表示key, value
E: 表示Element
?: 表示不确定类型
 */
public class StudentForGen<T1, T2> {
    private T1 javaScore;
    private T2 oracleScore;
    //泛型申明不能使用static修饰。
//    private static T1 test;

    public T2 getOracleScore() {
        return oracleScore;
    }

    public void setOracleScore(T2 oracleScore) {
        this.oracleScore = oracleScore;
    }

    public T1 getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(T1 javaScore) {
        this.javaScore = javaScore;
    }
}
