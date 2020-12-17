package code.leet;

import org.junit.Test;

public class Solution {
    //动态规划法
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    @Test
    public void mainTest() {
        System.out.println(uniquePaths(2, 2));
    }

    @Test
    public void mainTest1() {
        int y = 0;
        //注意"="是赋值,"=="才是相等
        //这里的y=++y 是先运算在赋值，先运算++y完了后y的值是1,然后在赋值给原来等于0的y
        y = ++y;// y==0,++y==y+1; 结果y=++y == y+1 == 0+1 ==1
        y = ++y;// y==1,++y==y+1; 结果y=++y == y+1 == 1+1 ==2
        y = ++y;// y==2,++y==y+1; 结果y=++y == y+1 == 2+1 ==3
        y = ++y;// y==3,++y==y+1; 结果y=++y == y+1 == 3+1 ==4
        y = ++y;// y==4,++y==y+1; 结果y=++y == y+1 == 4+1 ==5
        System.out.println("y=" + y);//5
        int i = 0, a = 2, m = 0;
        // i==0,i++==0; 结果i=i++ == (记住先赋值后运算)i=i,i=i+1(由于是i++运算这里我们输出的i只取先赋值的结果也就是i=i)
        i++; //a = i , i = i+1
        i++;
        i++;
        i++;
        System.out.println("i=" + i);//0
        //
        m = m++;//m = m,m = m+1
        System.out.println("m=" + m);


        int k = 1, j = 0;
        System.out.println("k++:" + (k++));
        System.out.println(k);
    }

}
