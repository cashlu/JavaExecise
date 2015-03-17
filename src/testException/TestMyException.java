package testException;

/**
 * Created by cashlu on 14/11/29.
 */
public class TestMyException extends Exception {
    public TestMyException(){

    }

    public TestMyException(String message){
        super(message);
    }
}

class Test{
    void test() throws TestMyException{
        ///
    }

    public static void main(String[] args) {
        try {
            new Test().test();
        } catch (TestMyException e) {
            e.printStackTrace();
        }
    }
}