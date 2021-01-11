package code.shangguigu.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t 办理");
            });
        }
       // executor.submit()
    }
}
