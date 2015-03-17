package testThread.ticketSellSystem;

/**
 * 创建多线程的第二种方式，实现Runnable接口。
 * 步骤：
 * 1、定义类，实现Runnable接口。
 * 2、重写Runnable接口的run()方法。将线程要执行的代码放到run()方法中。
 * 3、通过Thread类创建线程对象。
 * 4、将Runnable接口的子类对象，作为实参传递给Thread类的构造器函数。
 * 5、调用Thread类的start()方法。
 * <p/>
 * 实现Runnable接口而不继承Thread类来实现多线程的优点：
 * 1、避免了JAVA只能单继承的局限性。
 * 2、Ticket2类的资源被独立出来。以本例举例，如果Ticket2类继承Thread，那么该类会被创建4个对象，
 * 其中的ticket就会被初始化4次，变成400个，那么必须将该变量修饰为static，但是static占用的资源
 * 不会被很好的回收。如果实现Runnable接口来实现的，该类只会被实例化一次，避免了资源的浪费。
 * <p/>
 * 总结来说：
 * 继承Thread类：线程代码存放在Thread子类的run()方法中。
 * 实现Runnable接口：线程代码存放在Runnable子类的run()方法中。
 * <p/>
 * Created by cashlu on 15/2/4.
 */
public class TicketSell2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
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

class Ticket2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " selling No." + ticket--);
            } else {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " 估清！！！！");
    }
}
