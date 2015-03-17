package testException.ExceptionExercise;

/**
 * 老师停止讲课的异常。用于处理电脑爆炸的异常。
 * Created by cashlu on 15/3/14.
 */
public class StopPrelectException extends Exception {
    public StopPrelectException(String message) {
        super(message);
    }
}
