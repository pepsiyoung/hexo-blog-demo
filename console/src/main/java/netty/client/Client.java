package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.client.codec.MyFrameDecoder;
import netty.client.codec.MyFrameEncoder;
import netty.client.dispatcher.ResponseDispatcherHandler;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(new NioEventLoopGroup());

        LoggingHandler loggingHandler = new LoggingHandler(LogLevel.INFO);

        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                pipeline.addLast(new MyFrameDecoder());
                pipeline.addLast(new MyFrameEncoder());

                pipeline.addLast(new StringDecoder());
                pipeline.addLast(new StringEncoder());

                pipeline.addLast(new ResponseDispatcherHandler());
                pipeline.addLast(loggingHandler);
            }
        });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9090);
        channelFuture.sync();

        channelFuture.channel().writeAndFlush("Hello World1");
        channelFuture.channel().writeAndFlush("Hello World2");

        channelFuture.channel().closeFuture().sync();
    }
}
