package code.shangguigu.JVM.code;

public class JVMNote {
    public static void main(String[] args) {
        T1 t1 = new T1();
        //t1.m();
        byte[] b = new byte[50*1024*1024];
    }
}
class T1 {
    public void m(){
        m();
    }
}
