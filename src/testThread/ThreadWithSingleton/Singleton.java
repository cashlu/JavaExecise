package testThread.ThreadWithSingleton;

/**
 * 单例设计模式的懒汉模式默认线程不安全，多线程情况下需要处理。
 * Created by cashlu on 15/2/5.
 */
public class Singleton {
    public static void main(String[] args) {
        Single s = Single.getInstance();

    }
}

//使用同步代码块
class Single {
    private static Single s = null;

    private Single() {
    }

    public static Single getInstance() {
        if (s == null) {
            synchronized (Single.class) {
                if (s == null) {
                    s = new Single();
                    System.out.println("新建对象成功" + Thread.currentThread().getName());
                }
            }
        }
        return s;
    }
}

//使用同步方法(开销更大)
class Single2 {
    private static Single2 s = null;

    private Single2() {
    }

    public static synchronized Single2 getInstance() {
        if (s == null) {
            s = new Single2();
            System.out.println("新建对象成功" + Thread.currentThread().getName());
        }
        return s;
    }
}

//线程不安全的懒汉模式

class SingleNotSaft{
    private static SingleNotSaft s = null;

    public SingleNotSaft() {}

    public static SingleNotSaft getInstance(){
        if (s == null){
            s = new SingleNotSaft();
            System.out.println("新建对象成功" + Thread.currentThread().getName());
        }
        return s;
    }
}