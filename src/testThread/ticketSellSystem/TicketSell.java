package testThread.ticketSellSystem;

/**
 * 模拟多窗口售票业务，由4各线程来销售100张票，直到售完。
 * Created by cashlu on 15/2/4.
 */

class Ticket extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        super.run();
        while (true) {
            if (ticket > 0) {
                System.out.println(currentThread().getName() + " Sale: " + ticket--);
            }else {
                break;
            }
        }
        System.out.println(currentThread().getName() + " 估清！！！！");
    }
}

public class TicketSell {


    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

