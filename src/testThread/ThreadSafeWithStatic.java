package testThread;

/**
 * 如果同步方法为静态方法，那么其同步锁为该类的字节码对象（类名.class）。
 * 因为静态属性或方法进入内存时，还没有类的对象产生，但是JVM会在内存中生存该类的字节码文件对象。
 * Created by cashlu on 15/2/5.
 */
public class ThreadSafeWithStatic {
    public static void main(String[] args) {
        TicketStatic t = new TicketStatic();
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

class TicketStatic implements Runnable {
    private static int ticket = 100;
    Object o = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (true) {
                //因为方法是static，所以其同步锁为TicketStatic.class
                synchronized (TicketStatic.class) {
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
    public static synchronized void sellTicket() {
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
