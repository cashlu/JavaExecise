package testException;

/**
 * Created by cashlu on 14/11/27.
 */
public class TestException {
    public static void main(String[] args) {

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            //打印异常信息
            System.out.println(e.getMessage());
            System.out.println("--------------");
            //打印异常名称+异常信息
            System.out.println(e.toString());
            System.out.println("--------------");
//            //打印异常名称+异常信息+异常出现位置（JVM默认调用该方法）
            e.printStackTrace();
        }
    }
}
