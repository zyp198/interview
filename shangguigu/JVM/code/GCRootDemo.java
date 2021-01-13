package code.shangguigu.JVM.code;

public class GCRootDemo {
    public static void main(String[] args) {
        GCRootDemo gcRootDemo = new GCRootDemo();
        System.out.println(gcRootDemo.getClass().getClassLoader().getParent().getParent());
        String string = new String();
        System.out.println(string.getClass().getClassLoader());
        int num = 20;
        changeValue(num);
        System.out.println(num);
    }
    public static void changeValue(int num){
        num = 30;
        System.out.println(num);
    }
}
