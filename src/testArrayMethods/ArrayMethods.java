package testArrayMethods;

import java.util.Arrays;

/**
 * Created by cashlu on 14/11/20.
 */
public class ArrayMethods {
    public static void main(String[] args) {
        int a[] = {1, 4, 33, 78, 2, 3, 98, 32};

        //数组的排序
        Arrays.sort(a);

        //数组转字符串
        String str = Arrays.toString(a);
        System.out.println(str);

        //二分法查找数组内元素index
        System.out.println(Arrays.binarySearch(a, 78));

        //数组的填充，用特定元素填充数组特定位置（包头不包尾）
        Arrays.fill(a, 2, 4, 999);
        System.out.println(Arrays.toString(a));
    }
}
