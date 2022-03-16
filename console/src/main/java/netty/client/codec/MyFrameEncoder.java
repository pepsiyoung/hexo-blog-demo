package netty.client.codec;


import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 客户端编码器
 */
public class MyFrameEncoder extends LengthFieldPrepender {
    public MyFrameEncoder() {
        super(2);
    }
}
