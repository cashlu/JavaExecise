package testThread.testDeadLock;

/**
 * 写出一个同步死锁
 *
 * 原理：
 * A、B两个锁，两个线程先后启动，分别拿到了两个锁，要执行下一步，必须拿到对方所持有的那个锁，
 * 这时候线程锁死。
 * Created by cashlu on 15/2/5.
 */

class TestDeadLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}

class Test implements Runnable {
    private boolean flag;

    public Test(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.lockA) {
                System.out.println("if lock A");
                synchronized (MyLock.lockB) {
                    System.out.println("if lock B");
                }
            }
        } else {
            synchronized (MyLock.lockB) {
                System.out.println("else lock B");
                synchronized (MyLock.lockA) {
                    System.out.println("else lock A");
                }
            }

        }
    }
}

class MyLock {
    static Object lockA = new Object();
    static Object lockB = new Object();

}
