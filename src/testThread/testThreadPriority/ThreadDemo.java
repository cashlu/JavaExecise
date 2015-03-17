package testThread.testThreadPriority;

/**
 * 测试多线程的优先级。需要注意的是，优先级不是绝对的顺序指定，是共享资源冲突时的优先概率控制，
 * 程序员并不能精确的控制线程的执行先后顺序。
 * Created by cashlu on 15/3/1.
 */
public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 100000000; i++) {
            if (Thread.currentThread().isAlive()) {
                count++;
                System.out.printf("正在执行------%s------%d\n", Thread.currentThread().getName(), count);
            }
        }
    }
}
