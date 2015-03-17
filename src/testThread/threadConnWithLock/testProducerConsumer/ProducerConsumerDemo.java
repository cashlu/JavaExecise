package testThread.threadConnWithLock.testProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟生产消费流程，没生产一个产品，消费一个产品，依次进行。
 * 具有生产、消费两个线程来操作共同的资源。
 * <p/>
 * 升级版本！使用Lock替代同步。
 * Created by cashlu on 15/2/6.
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Res res = new Res();
        Producer producer = new Producer(res);
        Consumer consumer = new Consumer(res);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(producer);
        Thread t4 = new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Res {
    private String name;
    private int count = 1;
    private boolean hasRes = false;
    //创建锁对象
    private Lock lock = new ReentrantLock();
    //创建lock对象的Condition对象，一个lock对象可以有多个Condition对象
    private Condition conditionPro = lock.newCondition();
    private Condition conditionCon = lock.newCondition();

    public void in(String name) throws InterruptedException {
        lock.lock();
        try {
            while (hasRes) {
                //生产等待
                conditionPro.await();
            }
            this.name = name + "---" + count++;
            System.out.println(Thread.currentThread().getName() + "...Producer......" + this.name);
            hasRes = true;
            //消费唤醒
            conditionCon.signal();
        } finally {
            //释放锁
            lock.unlock();
        }
    }


    public void out() throws InterruptedException {
        lock.lock();
        try {
            while (!hasRes) {
                conditionCon.await();
            }
            System.out.println(Thread.currentThread().getName() + "...Consumer..." + this.name);
            hasRes = false;
            conditionPro.signal();
        } finally {

            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private Res res;

    public Producer(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                res.in("商品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Res res;

    public Consumer(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                res.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}