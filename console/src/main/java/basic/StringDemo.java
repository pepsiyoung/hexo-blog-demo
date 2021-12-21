package basic;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = new String("12") + new String("34");
        s1.intern();
        String s2 = "1234";

        // 返回Java虚拟机中的堆内存总量
//        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
//
//        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
//        System.out.println("-Xms : " + initialMemory + "M");
//        System.out.println("-Xmx : " + maxMemory + "M");
    }
}
