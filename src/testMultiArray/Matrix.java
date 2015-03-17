package testMultiArray;

/**
 * 通过矩阵的加法，来测试二维数组
 * Created by cashlu on 14/11/19.
 */

public class Matrix {

    /**
     * printMatrix(int matrix[][])方法封装了矩阵的打印算法
     * static方法是在程序编译期就存入内存中的，所以不需要实例化对象来调用
     * @param matrix 传入一个二维数组对象
     */
    private static void printMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * add(int matrixA[][], int matrixB[][])方法实现了矩阵相加的算法，即相同位置的元素相加。
     * @param matrixA
     * @param matrixB
     * @param aLength 传入数组的一维长度
     * @param aILength 传入数组的二维长度
     * @return 返回一个新的数组对象，为相加的结果。
     */
    private static int[][] add(int matrixA[][], int matrixB[][], int aLength, int aILength) {
        int matrixC[][] = new int[aLength][aILength];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixC;
    }


    public static void main(String[] args) {

        //定义矩阵A
        int a[][] = {
                {1, 3, 1},
                {2, 4, 1},
                {1, 1, 1}
        };

        //定义矩阵B
        int b[][] = {
                {3, 4, 1},
                {5, 6, 1},
                {1, 1, 1}
        };

        int c[][];
        c = add(a, b, a.length, a[0].length);

        System.out.println(a.length);
        System.out.println(a[0].length);

//        //打印矩阵
        System.out.println("Matrix A:");
        printMatrix(a);
        System.out.println("Matrix B:");
        printMatrix(b);
        System.out.println("Matrix C:");
        printMatrix(c);

    }
}
