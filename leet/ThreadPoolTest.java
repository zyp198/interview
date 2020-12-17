package code.leet;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    static int num = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                //System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000l);
                    printHello(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void printHello(int s) {
        num = num + 1;
        num = num - 1;
        System.out.println(num);
    }

}
