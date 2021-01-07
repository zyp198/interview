package code.shangguigu;

public class VolatileDemo {

    static class MyData{
       volatile int number = 0;
        /**
         * volatile 的三特性 可见性 不保证原子性 禁止指令重排
         */
        public void add(){
            this.number = 3;
        }
        public  void addplusplus(){
            this.number++;
        }

    }

    /**
     * 可见性 即 一个线程修改了一个值，其他线程立刻知道该值已经被修改了。线程之间的通信（）是通过主内存来完成的。
     * @param args
     */
   /* public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"come in");
                Thread.sleep(3000);
                myData.add();
                System.out.println(myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        while (myData.number == 0){

        }
        System.out.println("end->number = "+myData.number);
    }*/

    /**
     * 不保证原子性
     * @param args
     */
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 2000; j++) {
                    myData.addplusplus();
                }
            },"BBB").start();
        }
        //等待上面20个线程全部计算完成，在用main线程得到最终的结果
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(myData.number);

    }
}
