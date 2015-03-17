package testException;

/**
 * 多异常的处理。这里的第二个/ by zero异常没有被处理，因为异常压根就没有产生。
 * 数组越界异常发生时，程序就跳转处理异常了。div方法并没有执行完全。
 * Created by cashlu on 15/3/8.
 */
class DivDemo{
    int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        //制造了第一个异常：数组越界
        int[] arr = new int[a];
        System.out.println(arr[a + 1]);
        //制造了第二个异常：/ by zero
        return a / b;
    }
}


public class testExceptionWithDiv {
    public static void main(String[] args){
        DivDemo demo = new DivDemo();
        try {
            int res = demo.div(4, 0);
            System.out.println(res);
        }catch (ArithmeticException e){
            System.out.println("Cannot div by zero!!!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds Exception");
        }
    }

}

