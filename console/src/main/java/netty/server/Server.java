package netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.server.codec.MyFrameDecoder;
import netty.server.codec.MyFrameEncoder;
import netty.server.handler.MsgServerProcessHandler;

public class Server {
    public static void main(String[] args) throws InterruptedException {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));

        serverBootstrap.group(new NioEventLoopGroup());


        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                pipeline.addLast(new MyFrameDecoder());
                pipeline.addLast( new MyFrameEncoder());

                pipeline.addLast(new StringDecoder());
                pipeline.addLast(new StringEncoder());

                pipeline.addLast(new MsgServerProcessHandler());
            }
        });

        ChannelFuture channelFuture = serverBootstrap.bind(9090).sync();
        channelFuture.channel().closeFuture().sync();
    }
}
