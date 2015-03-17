package testException.ExceptionExercise2;

/**
 * 圆形类.
 * Created by cashlu on 15/3/17.
 */
public class Circle implements shape {
    private double redius;
    private double area;

    public Circle(double redius) {
        if (redius <= 0){
            throw new IllegalValue("圆的半径不能小于等于0");
        }
        this.redius = redius;
    }

    @Override
    public void getArea(){
        area = redius * Math.PI;
        System.out.println("圆的面积是：" + area);
    }
}
