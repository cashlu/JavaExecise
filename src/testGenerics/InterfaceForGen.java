package testGenerics;

/**
 * 泛型接口
 * 1、接口中，泛型不能使用在常量上。
 * Created by cashlu on 15/2/2.
 */
public interface InterfaceForGen<T> {
    void test(T t);
}
