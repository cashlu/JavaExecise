package testException.ExceptionExercise2;

/**
 * 创建一个“图形”接口。所有实现该接口的类，都必须重写求面积的方法。
 * Created by cashlu on 15/3/16.
 */
public interface shape {
    void getArea() throws IllegalValue;
}
