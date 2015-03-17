package testThread;

/**
 * 测试同步函数的使用方法。
 * 同步函数的锁是调用它的对象。
 * Created by cashlu on 15/2/5.
 */
public class SyncMethodTest {
    public static void main(String[] args) {
        Customer c = new Customer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        Thread t4 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Bank{
    private double sum;

    //只需要将需要同步的方法加一个synchronized修饰符，就会将整个方法同步。
    public synchronized void add(double n){
        sum += n;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " sum = " + sum);
    }
}

class Customer implements Runnable{
    Bank b = new Bank();
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            b.add(100);
        }
    }
}