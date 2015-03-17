package testThread.testJoinYieldSleep;

/**
 * join 合并线程
 * 当main线程运行了50次左右时，将t线程加入main线程
 * Created by cashlu on 15/2/27.
 */
public class JoinDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        JoinDemo demo = new JoinDemo();
        Thread t = new Thread(demo); //创建线程
        t.start();  //线程就绪

        for (int i = 0; i < 1000; i++) {
            if (i % 20 == 0) {
                Thread.yield();
            }
            System.out.println("main..." + i);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("join..." + i);
        }
    }
}

