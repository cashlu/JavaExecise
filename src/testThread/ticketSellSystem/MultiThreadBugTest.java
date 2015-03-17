package testThread.ticketSellSystem;

/**
 * 通过这段代码，来还原出多线程可能出现的bug——多线程安全问题。
 * 票只有一张，按照业务逻辑，四个线程应该只有一个可以卖出一张票，程序结束。
 * 但是有可能第1(N)个线程在判断ticket>0后，CPU将其挂起，后续线程陆续判断为true,
 * 那么ticket--会被执行多次，从而变成负数。
 * <p/>
 * 解决办法：同步代码块
 * Created by cashlu on 15/2/4.
 */
public class MultiThreadBugTest {
    public static void main(String[] args) {
        Ticket3 ticket = new Ticket3();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Ticket3 implements Runnable {
    private int ticket = 1;
    Object o = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (o) { //对象o叫做“锁”，可以理解为公用厕所的门锁。呵呵
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " selling No." + ticket--);
                } else {
                    break;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " 估清！！！！");
    }
}
