package code.shangguigu.JUC;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    static class MyThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 1024;
        }
    }

    public static void main(String[] args) {
      //  FutureTask futureTask = new FutureTask(new MyThread()); 2147483647 2147483648
        System.out.println(Integer.MIN_VALUE);
      //  获取CPU内核数目
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
































}
