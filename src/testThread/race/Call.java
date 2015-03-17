package testThread.race;

import java.util.concurrent.*;

/**
 * 使用Callable<>接口来创建线程。
 * 好处是：
 * 1、可以返回值
 * 2、可以申明异常
 * Created by cashlu on 15/2/14.
 */
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Race tor = new Race("老不死的", 2000);
        Race rab = new Race("小年轻", 500);
        //创建线程，int参数代表线程的个数
        ExecutorService service = Executors.newFixedThreadPool(2);
        //获取值，参数为实现类的对象。
        Future<Integer> result1 = service.submit(tor);
        Future<Integer> result2 = service.submit(rab);

        //让主线程睡10秒，相当于让乌龟和兔子跑了10秒
        Thread.sleep(10000);
        //停止线程体循环
        tor.setFlag(false);
        rab.setFlag(false);

        System.out.println("老不死的跑了---->" + result1.get() + "步");
        System.out.println("小年轻跑了---->" + result2.get() + "步");

        //停止线程（停止服务）
        service.shutdownNow();

    }
}

class Race implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flag = true;
    private int step = 0;

    public Race() {
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}
