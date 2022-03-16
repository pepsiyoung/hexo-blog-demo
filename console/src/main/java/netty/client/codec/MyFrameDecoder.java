package netty.client.codec;


import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 客户端解码器
 */
public class MyFrameDecoder extends LengthFieldBasedFrameDecoder {
    public MyFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
