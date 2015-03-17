package testException.ExceptionExercise2;

/**
 * Created by cashlu on 15/3/16.
 */
public class Test {
    public static void main(String[] args) {
        Rec r = new Rec(5, 12);
        r.getArea();

        Circle c = new Circle(10);
        c.getArea();

        System.out.println("Hello");
    }
}
