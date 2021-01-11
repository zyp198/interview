package code.shangguigu.JVM.code;

public class GCRootDemo {
    public static void main(String[] args) {
        GCRootDemo gcRootDemo = new GCRootDemo();
        System.out.println(gcRootDemo.getClass().getClassLoader().getParent().getParent());
        String string = new String();
        System.out.println(string.getClass().getClassLoader());
    }
}
