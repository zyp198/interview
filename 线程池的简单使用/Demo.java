package code.线程池的简单使用;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    /**
     * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
     * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
     * @param args
     */
 /*   public static void main(String[] args) {
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final  int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("执行"+ index+",线程名称:"+threadName);
                }
            });
        }
        executorService.shutdown();
    }*/
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        //Executors.newFixedThreadPool();
        //Executors.newSingleThreadExecutor();
        //Executors.newScheduledThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    method1();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                method2();
                System.out.println(Thread.currentThread().getName());
            }
        });
        executorService.shutdown();
    }

    public static void method1() throws InterruptedException {
        Thread.sleep(3*1000);
        System.out.println("方法一执行完成");
    }
    public static void method2() {
        for (int i = 0; i < 3; i++) {
            System.out.println("method2 执行"+i);
        }
    }
}
