package code.shangguigu.JVM.code;

import java.util.WeakHashMap;

public class Test {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println((double)Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().availableProcessors());
        //WeakHashMap
        new T();
    }
}
class T{
    T(){
        System.out.println("A");
    }
    {
        System.out.println("B");
    }
    static {
        System.out.println("C");
    }
}