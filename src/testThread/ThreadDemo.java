package testThread;

/**
 *
 * Created by cashlu on 15/2/3.
 */

class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 2000; i < 3000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args) {
        Thread1 td1 = new Thread1();
        Thread2 td2 = new Thread2();
        td1.start();
        td2.start();
    }
}
