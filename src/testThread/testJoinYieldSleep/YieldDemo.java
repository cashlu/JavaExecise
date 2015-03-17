package testThread.testJoinYieldSleep;

/**
 * Yield 让正在运行的线程进入就绪状态，相当于让线程等待了
 * Created by cashlu on 15/2/27.
 */
public class YieldDemo implements Runnable{
    public static void main(String[] args) {
        YieldDemo yield = new YieldDemo();
        Thread t = new Thread(yield);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Yield..." + i);
        }
    }
}
