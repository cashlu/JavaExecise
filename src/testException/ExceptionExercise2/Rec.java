package testException.ExceptionExercise2;

/**
 * 长方形类。
 * Created by cashlu on 15/3/16.
 */
public class Rec implements shape {
    private double length;
    private double height;
    private double area;

    public Rec(double height, double length) {
        if (height <= 0 || length <= 0){
            throw new IllegalValue("长方形的长、宽不能小于等于0");
        }
        this.height = height;
        this.length = length;
    }

    @Override
    public void getArea() {
        area = length * height;
        System.out.println("长方形的面积是:" + area);
    }
}
