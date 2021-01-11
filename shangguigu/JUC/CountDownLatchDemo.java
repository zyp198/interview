package code.shangguigu.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * 1、让一部分线程阻塞直到另外一些线程完成以后才被唤醒
 * 2、CountDownLatch主要有两个方法，await 和 countdown。在sixCountry或者closeDoor方法中。main线程调用await方法时会被阻塞，只有当countDown调用五次后才会唤醒main线程。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        //closeDoor();
        sixCountry();
    }
    public static void closeDoor() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + "上完自习");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("离开");
    }

    public static void sixCountry() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach(i).getCountry()).start();
        }
        countDownLatch.await();
        System.out.println("秦国统一");
    }
}
