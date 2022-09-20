package designModel.observer;

/**
 * 观察者模式
 */
public class Demo {
    public static void main(String[] args) {
        NewSubject newSubject = new NewSubject() {
        };
        newSubject.register((String orderNo) -> System.out.println("订单【" + orderNo + "】状态更新"));
        newSubject.register((String orderNo) -> System.out.println("订单【" + orderNo + "】已发货"));
        newSubject.notify("A001");
    }
}
