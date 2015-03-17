package testMultiArray;

/**
 * Created by cashlu on 14/11/18.
 */
public class MultiArray {
    public static void main(String[] args) {
        int a[][] = new int[3][];
        a[0] = new int[2];
        a[1] = new int[3];
        a[2] = new int[4];

        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;
        a[1][2] = 5;
        a[2][0] = 6;
        a[2][1] = 7;
        a[2][2] = 8;
        a[2][3] = 9;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
