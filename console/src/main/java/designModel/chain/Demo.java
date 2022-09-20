package designModel.chain;

import java.util.function.Consumer;

/**
 * 责任链模式
 */
public class Demo {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        // 传统
        Processor p1 = new ProcessorImpl1(null);
        Processor p2 = new ProcessorImpl2(p1);
        p2.process("something happened");
    }

    static void test2() {
        // 简洁
        Consumer<String> p1 = param -> System.out.println("processor 1 is processing:" + param);
        Consumer<String> p2 = param -> System.out.println("processor 2 is processing:" + param);
        p2.andThen(p1).accept("something happened");
    }
}
