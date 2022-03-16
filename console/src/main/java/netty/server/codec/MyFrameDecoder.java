package netty.server.codec;


import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class MyFrameDecoder extends LengthFieldBasedFrameDecoder {
    public MyFrameDecoder() {
        super(10240, 0, 2, 0, 2);
    }
}
