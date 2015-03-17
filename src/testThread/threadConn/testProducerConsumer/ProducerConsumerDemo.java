package testThread.threadConn.testProducerConsumer;

/**
 * 模拟生产消费流程，没生产一个产品，消费一个产品，依次进行。
 * 具有生产、消费两个线程来操作共同的资源。
 * Created by cashlu on 15/2/6.
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Res res = new Res();
        Producer producer = new Producer(res);
        Consumer consumer = new Consumer(res);


        /*
        双线程没有问题，如果这里创建4个线程，Producer和Consumer各两个，那么就会出现问题。
        问题的现象是重复的生产或者重复的消费。原因在于同对象的两个线程都判断hasRes后wait，然后
        再被唤醒，就不会再去判断一次hasRes，造成重复处理Res对象。

        解决的办法是判断flag的方法，由if的一次判断改为while的多次循环判断，不过只是简单的改这里，
        会造成所有线程全部wait。

        所以还需要处理。处理的方式就是notifyAll()。每次当一个线程改变状态后，都把所有wait的线程唤醒。
        所有线程重新进入while循环，判断hasRes，然后有一个线程操作资源，其他线程wait。
         */
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

    public synchronized void in(String name) {
        while (hasRes) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "...Producer......" + this.name);
        hasRes = true;
        this.notifyAll();
    }


    public synchronized void out() {
        while (!hasRes) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...Consumer..." + this.name);
        hasRes = false;
        this.notifyAll();

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
            res.in("商品");
        }
    }
}

class Consumer implements Runnable{
    private Res res;

    public Consumer(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            res.out();
        }
    }
}