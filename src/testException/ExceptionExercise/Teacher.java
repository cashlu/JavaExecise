package testException.ExceptionExercise;

/**
 * 老师类
 * Created by cashlu on 15/3/13.
 */
class Teacher {
    private String name;
    public Computer computer;

    public Teacher(String name) {
        this.name = name;
        computer = new Computer();
    }

    //老师讲课的方法
    public void prelect() throws StopPrelectException {
        try {
            computer.run();
        } catch (LanPingException e) {
            System.out.println(e.getMessage());
            computer.reset();
        } catch (MaoYanException e) {
            System.out.println(e.getMessage());
            for (int i = 0; i < 3; i++) {
                System.out.println("The teacher is repairing the computer...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            computer.reset();
        } catch (BoomException e) {
            /*
            当电脑爆炸，讲课不能继续了，并且这个异常老师是不能处理的，只能终端讲课。
            但是这里也不能抛出电脑爆炸的异常，因为这个异常调用者也不能处理（真实业务逻辑）。
            因为这里要将异常转换，转换为调用者可以处理的异常。
            */
            throw new StopPrelectException("老师不能讲课了！！！");
        }
        /*
        如果state==4的话，那么这一句不执行，因为在catch BoomException异常的时候，
        又抛出了一个异常，因此程序执行中断了。
         */
        System.out.println("The teacher is prelecting...");
    }
}