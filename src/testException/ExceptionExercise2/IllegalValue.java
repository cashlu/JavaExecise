package testException.ExceptionExercise2;

/**
 * 求面积参数的非法值异常。在长方形中，长、高都不能小于等于0；圆形中，半径不能小于等于0。
 * Created by cashlu on 15/3/17.
 */
public class IllegalValue extends RuntimeException {
    public IllegalValue(String message) {
        super(message);
    }
}
