package testGenerics.gen;

/**
 * 这是一个简单的泛型类。声明时，类名后加<T>。申明变量时，变量的类型是T。因为不确定类型。
 * Created by cashlu on 15/2/2.
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
