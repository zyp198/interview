package code.shangguigu;

import java.util.concurrent.atomic.AtomicInteger;

//CAS 比较并交换,是用来实现多线程同步的原子指令，用来解决高并发情况下线程不安全的问题。它将内存位置的值和给定的值进行比较，只有在相同的情况下，该内存位置的内容修改为给定的新值。
//这是作为单个原子操作完成的。原子性保证新值基于最新信息计算；如果该值在同一时间被另一个线程修改，则写入失败。操作结果必须说明是否替换；这可以通过一个简单的布尔值，或通过返回从内存位置读取的值来完成。
public class CASDemo {
   /* static class People{
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = 12;
        }
        public People(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        People people = new People("zhangsan");
        System.out.println(people.getName());
        people.setAge(11);
        System.out.println(people.getAge());
        String str = "133";
        people.setName(str);
        System.out.println(str);
    }*/
   public static void main(String[] args) {
       AtomicInteger atomicInteger = new AtomicInteger(0);
       boolean result = atomicInteger.compareAndSet(0,1);
       System.out.println("操作结果："+result+atomicInteger.get());
       boolean result2 =  atomicInteger.compareAndSet(0,2);
       System.out.println("操作结果："+result2+atomicInteger.get());
   }

}
