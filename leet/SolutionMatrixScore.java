package code.leet;

import java.util.Arrays;

public class SolutionMatrixScore {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {0, 1}, {0, 1}, {0, 0}};
        // int [][] matrix = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int sum = matrixScore(matrix);
        System.out.println(sum);
    }

    /*
    *
    *
0011
1010
1100

1100
1010
1100

1110
1000
1110

1111
1001
1111
    * */
    public static int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        //对第一列元素进行翻转，保证最高位的值为 1
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        //从第二列开始，记录每一列0的个数和1的个数
        for (int i = 1; i < col; i++) {
            int count_0 = 0, count_1 = 0;
            for (int j = 0; j < row; j++) {
                if (A[j][i] == 0) {
                    count_0 = count_0 + 1;
                } else {
                    count_1 = count_1 + 1;
                }
            }
            //System.out.println(count_0+"---"+count_1);
            if (count_0 > count_1) {
                for (int j = 0; j < row; j++) {
                    A[j][i] = A[j][i] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        return binSum(A, row, col);
    }

    /**
     * @param a
     * @param row
     * @param col
     * @return
     */
    private static int binSum(int[][] a, int row, int col) {
        //二进制转十进制
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = col - j - 1;
                sum = sum + (int) (a[i][j] * Math.pow(2, temp));
            }
        }
        return sum;
    }
}
