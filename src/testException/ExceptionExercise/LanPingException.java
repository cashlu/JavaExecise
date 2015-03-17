package testException.ExceptionExercise;

/**
 * 定义电脑蓝屏的异常
 * Created by cashlu on 15/3/13.
 */
public class LanPingException extends Exception{
    public LanPingException(String msg){
        super(msg);
    }
}
