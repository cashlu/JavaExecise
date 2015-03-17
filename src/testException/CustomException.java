package testException;

/**
 * 自定义异常。
 * 本程序中的除法，除了不能被0除以外，也不能被负数除，否则抛异常。
 * 不能被0除JDK已经定了相关的异常，需要自己定义不能被负数除的异常。
 * Created by cashlu on 15/3/11.
 */
public class CustomException {
    public static void main(String[] args) {
        Demo demo = new Demo();
        /*
        如果方法内部调用一个有可能抛出异常的方法，那么就必须对该异常处理，要么抛出，要么捕获。
        因为main方法已经是最高级的方法了，如果抛出的话，就等于抛给了JVM，这样并不好，所以做try/catch处理。
         */
        try {
            demo.div(4, -1);
        } catch (FushuException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("错误的数值是：" +  e.getValue());
        }
    }
}



class Demo{
    /*
    * 自定义除法方法，定义一个规则，除了被除数不能为0外，也不能为负数。
    * 如果在方法内部出现了throw异常对象，那么必须对该异常进行处理，
    * 要么在方法内部对该异常做try/catch处理，要么在方法申明上抛给上一级调用者。
    * */
    int div(int a, int b) throws FushuException{
        if (b < 0){
            throw new FushuException("除数不能<0", b);
        }
        return a / b;
    }
}

/**
 * 定义不能被负数除的异常类。
 * 因为Exception的父类Throwable已经定义了带有异常信息参数的构造器函数，
 * 所以在子类实现中，只需要在构造器函数中调用父类的构造器函数，并传入一个String参数代表异常信息即可。
 */
class FushuException extends Exception{
    private int value;

    //无参的构造函数
    FushuException(){}

    //带有异常信息参数的构造函数
    FushuException(String msg){
        super(msg);
    }

    //带有异常信息以及错误值的构造函数
    FushuException(String msg, int value){
        super(msg);
        this.value = value;
        this.getValue();
    }

    //value的get方法
    public int getValue() {
        return value;
    }
}