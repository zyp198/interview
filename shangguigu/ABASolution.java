package code.shangguigu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABASolution {
    static AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
    public static void main(String[] args) {
        new Thread(() -> {
            // 执行ABA操作
            System.out.println(atomicReference.compareAndSet(100, 101)+"\t"+atomicReference.get());
            System.out.println(atomicReference.compareAndSet(101, 100)+"\t"+atomicReference.get());
        }, "t1").start();

        new Thread(()->{
            // 暂停1秒钟t2线程，保证t1完成了一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019)+"\t" + atomicReference.get());
        }, "t2").start();
    }
}
