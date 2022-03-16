package netty.server.codec;


import io.netty.handler.codec.LengthFieldPrepender;

public class MyFrameEncoder extends LengthFieldPrepender {
    public MyFrameEncoder() {
        super(2);
    }
}
