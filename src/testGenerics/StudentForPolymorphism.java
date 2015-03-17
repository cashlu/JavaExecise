package testGenerics;



/**
 * 测试泛型的使用。
 * Created by cashlu on 15/2/1.
 */
public class StudentForPolymorphism {
    private Object javase;
    private Object oracle;

    public StudentForPolymorphism() {
    }

    public StudentForPolymorphism(Object javase, Object oracle) {
        this.javase = javase;
        this.oracle = oracle;
    }

    public Object getJavase() {
        return javase;
    }

    public void setJavase(Object javase) {
        this.javase = javase;
    }

    public Object getOracle() {
        return oracle;
    }

    public void setOracle(Object oracle) {
        this.oracle = oracle;
    }
}
