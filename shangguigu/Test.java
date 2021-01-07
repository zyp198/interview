package code.shangguigu;

import java.util.concurrent.locks.Lock;

public class Test {
    public static void main(String[] args) {
        synchronized(new Object()){} // 9: monitorenter  10: aload_1  11: monitorexit
        int a = 0,b,x;
        x = ++a; //a = a + 1; x = a;  x=1 a=1 先加再赋值
        System.out.println(x+"<>"+a);
        x = a++; //x = a; a = a+1; x=1 a=2 先赋值再加
        System.out.println(x+"<>"+a);
    }
}
