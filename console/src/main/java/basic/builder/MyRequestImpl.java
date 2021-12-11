package basic.builder;

import lombok.Data;

@Data
public class MyRequestImpl implements MyRequest.Builder {

    private String name;

    private String headerName;

    private String headValue;

    @Override
    public MyRequest.Builder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MyRequest.Builder header(String name, String value) {
        this.headerName = name;
        this.headValue = value;
        return this;
    }

    @Override
    public MyRequest build() {
        return new MyRequest(this);
    }
}
