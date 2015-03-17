package testException.ExceptionExercise;

/**
 * 老师讲课的测试类。用于模拟实际生活中老师讲课的环境。
 * 老师讲课需要有一个老师对象，还需要一个电脑对象。
 * 老师使用电脑来讲课。
 * Created by cashlu on 15/3/13.
 */
public class ExceptionExercise1 {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Simon Lo");
        teacher.computer.setState(4);
        try {
            teacher.prelect();
        } catch (StopPrelectException e) {
            System.out.println(e.getMessage());
            System.out.println("换个电脑");
        }

    }
}



