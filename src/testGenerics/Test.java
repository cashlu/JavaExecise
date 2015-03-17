package testGenerics;

/**
 * Created by cashlu on 15/2/2.
 */
public class Test<T> {
    private T var;

    public Test(T var) {
        this.var = var;
    }

    public void show(){
        System.out.println(var);
    }

    public static void main(String[] args) {
        Test<String> str = new Test<String>("seven");
        Test<Integer> inte = new Test<Integer>(7);
        str.show();
        inte.show();
    }
}

