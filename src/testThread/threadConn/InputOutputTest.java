package testThread.threadConn;

/**
 * 线程间通信
 * 创建一个唯一的Res对象r，分别有两个线程，一个线程对r赋值，另外一个线程将r输出。交替进行。
 * wait()方法等待
 * notify()方法唤醒
 * Created by cashlu on 15/2/5.
 */
public class InputOutputTest {
    public static void main(String[] args) {
        Res res = new Res();
        new Thread(new Input(res)).start();
        new Thread(new Output(res)).start();
    }
}

class Res {
    private String name;
    private String sex;
    //判断对象是否被赋值
    private boolean isEmpty = false;

    /**
     * 姓名、性别的设置方法。
     * 修饰为同步方法，是因为多线程运行时，该方法的代码块内在设置完姓名后，有可能线程会休眠，
     * 没有对性别赋值。
     * 赋值完成后，改写isEmpty的状态，然后唤醒其他正在等待的线程。
     *
     * @param name 姓名
     * @param sex  性别
     */
    public synchronized void set(String name, String sex) {
        if (!isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        isEmpty = false;
        this.notify();
    }

    /**
     * 输出方法，用于对象属性的输出。
     * 修饰为同步方法，是因为多线程程序有可能在方法的代码块没有完全执行完成就将线程挂起了。
     * 先判断对象的isEmpty状态是否为false，如果是的话，那么输出显示，然后将isEmpty赋值为true，
     * 再唤醒其他正在等待的线程。
     */
    public synchronized void out() {
        if (isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "..." + sex);
        isEmpty = true;
        this.notify();
    }
}


class Input implements Runnable {
    private Res r;

    public Input(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        /*
        变量x的作用是为了切换两种不同的复制方式。
         */
        int x = 0;
        while (true) {

            if (x == 0) {
                r.set("Mike", "Male");
            } else {
                r.set("小郑", "女");
            }
            x = (x + 1) % 2;
        }
    }
}

class Output implements Runnable {
    private Res r;

    public Output(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }
}