package basic.builder;

/**
 * 设计模式之构建器模式
 */
public class MyRequest {

    public interface Builder {

        public Builder name(String name);

        public Builder header(String name, String value);

        public MyRequest build();
    }

    private final String name;

    private final String headerName;

    private final String headValue;

    public MyRequest(MyRequestImpl build) {
        this.name = build.getName();
        this.headerName = build.getHeaderName();
        this.headValue = build.getHeadValue();
    }

    public static Builder newBuilder() {
        return new MyRequestImpl();
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "name='" + name + '\'' +
                ", headerName='" + headerName + '\'' +
                ", headValue='" + headValue + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MyRequest myRequest = MyRequest.newBuilder().name("zcy").header("xxx", "yyy").build();
        System.out.println(myRequest.toString());
    }
}
