package testThread;

/**
 * 以多窗口卖票需求为例，创建一个同步函数，一个同步代码块，
 * 分两次使用相同的锁和不同的锁，来验证线程安全问题。
 * <p/>
 * 使用不同锁：线程不安全
 * 使用相同锁：线程安全
 * Created by cashlu on 15/2/5.
 */
public class TestDoubleSync {
    public static void main(String[] args) {
        testThread.TicketStatic t = new testThread.TicketStatic();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t2.start();
    }
}

class Ticket implements Runnable {
    private int ticket = 1000;
    Object o = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (true) {
                //下面是同步代码块，使用的锁对象为o，这时候程序会出问题，产生多卖的问题。
                //因为两个同步锁不一样，改成this，问题解决。
                synchronized (this) {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " selling " + ticket--);
                    } else {
                        break;
                    }
                }
            }
        } else {
            sellTicket();
        }
    }

    //下面是同步方法，使用的锁是this。
    public synchronized void sellTicket() {
        while (true){
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " selling---- " + ticket--);
            }else {
                break;
            }
        }
    }
}
