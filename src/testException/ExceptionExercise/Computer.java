package testException.ExceptionExercise;

/**
 * 电脑类，老师用于讲课的工具。
 * Created by cashlu on 15/3/13.
 */
class Computer {
    private int state = 1;

    public void setState(int state) {
        this.state = state;
    }

    //电脑运行
    public void run() throws LanPingException, MaoYanException, BoomException {
        if (state == 2) throw new LanPingException("警告！！！电脑蓝屏了...");
        if (state == 3) throw new MaoYanException("警告！！！电脑冒烟了...");
        if (state == 4) throw new BoomException("Boommmmmmmmmmmmmm...");
        System.out.println("The computer is running...");
    }

    //电脑重启
    public void reset() {
        System.out.println("The computer is resetting...");
        state = 1;
        System.out.println("The computer is running...");
    }
}
