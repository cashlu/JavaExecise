package testThread;

/**
 * 多线程的使用方法。
 * this或static Thread.currentThread()都可返回当前线程对象。
 *
 * setName()或者构造函数传参都可设置线程的名称。getName()获取线程名称。
 * Created by cashlu on 15/2/3.
 */

public class ThreadDemo2 {
    public static void main(String[] args) {
        Test t1 = new Test("Thread-1");
        Test t2 = new Test("Thread-2");
        t1.start();
        t2.start();
        //main线程要执行的语句要放在其他线程启动的后面，否则会先执行下面的语句，
        // 完成后再开始交替执行t1和t2。
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread-main" + i);
        }
    }
}

class Test extends Thread {
    public Test(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            System.out.println(this.getName() + " " + i);
            /*
            this和Thread.currentThread()都能获取当前线程对象。
            currentThread()是一个静态方法，直接用类名来调用，这个更通用。
             */
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
