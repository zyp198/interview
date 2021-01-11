package code.shangguigu.JUC;

import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    //static AtomicInteger atomicReference = new AtomicInteger(0);
    static AtomicReference<String> atomicReference = new AtomicReference<String>("A");
    //static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,0); //加版本号解决ABA问题
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+atomicReference.compareAndSet("A","M")+"-->"+atomicReference.get());
            System.out.println(Thread.currentThread().getName()+atomicReference.compareAndSet("M","100")+"-->"+atomicReference.get());
        },"t1").start();
        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+atomicReference.compareAndSet("100","90")+"-->"+atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

    }
}
