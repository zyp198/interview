package code.shangguigu.JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        // List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //当别人吹捧你的时候，准备发大招呢。没有没有，只是问到的刚好会，有用到或者以前复习过。
        //add操作 非线程安全
        List<String> list = new CopyOnWriteArrayList<>();
   /*     for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();


        }*/
        String s = "123";
        String s1 = "123";
        System.out.println(s == s1);
        String s2 = new String("123");
        System.out.println(s2);
        System.out.println(s == s2);
        System.out.println(s == s2.intern());
    }
}
