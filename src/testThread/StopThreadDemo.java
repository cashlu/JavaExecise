package testThread;

/**
 * Created by cashlu on 15/2/13.
 */
public class StopThreadDemo {
    public static void main(String[] args) {
        Stop st = new Stop();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);

        t1.start();
        t2.start();

        int num = 0;
        while (true){
            if (num++ == 60){
//                st.setFlag(false);
                t1.interrupt();
                t2.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "..." + num);
        }
    }


}


class Stop implements Runnable{
    private boolean flag = true;

    @Override
    public synchronized void run() {
        while(flag){
            try {
                wait();
            }
            catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + "...Exception");
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "...running");
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

