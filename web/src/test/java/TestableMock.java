import com.alibaba.testable.core.annotation.MockInvoke;

public class TestableMock {

    public String substring(int a, int b) {
        return "pepsiYoung".substring(a, b);
    }

    public void execute() {
        System.out.println(substring(1, 2));
    }

    public static class Mock {
        // 放置Mock方法的地方
        @MockInvoke(targetClass = String.class)
        private String substring(int a, int b) {
            return "sub_string";
        }
    }
}
