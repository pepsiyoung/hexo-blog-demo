package netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class MsgServerProcessHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("读取:" + msg);
        if (ctx.channel().isActive() && ctx.channel().isWritable()) {
            ctx.writeAndFlush("Hello Netty");
        } else {
            System.out.println("not writable now, message dropped");
        }
    }
}
