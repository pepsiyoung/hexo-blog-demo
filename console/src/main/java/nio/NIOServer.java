package nio;

import lombok.SneakyThrows;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class NIOServer extends Thread {

    public static boolean switchBoolean = true;

    @SneakyThrows
    @Override
    public void run() {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            // 将该通道设置为非阻塞方式否则无法register
            serverSocketChannel.configureBlocking(false);
            // 注册到Selector，并说明关注点是连接(当有新连接时就会被唤醒)
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true && switchBoolean) {
                // 阻塞等待就绪的Channel，这是关键点之一
                int connectCount = selector.select();


                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    SocketChannel clientChannel;
                    if (key.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        clientChannel = channel.accept();
                        // 将处理对应的客户端信息socketChannel设置为非阻塞
                        clientChannel.configureBlocking(false);
                        // 为该通道注册读就绪事件, 选择器会询问该通道的状态,当该通道就绪时,
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        clientChannel = (SocketChannel) key.channel();
                        // 参数设置3 为了简化实现 不考虑半包、粘包问题
                        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
                        clientChannel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println("server:" + msg);
                        key.interestOps(SelectionKey.OP_WRITE);
                        if ("bye".equals(msg)) {
                            clientChannel.close();
                            switchBoolean = false;
                        }

                    } else if (key.isWritable()) {
                        clientChannel = (SocketChannel) key.channel();
                        clientChannel.write(Charset.defaultCharset().encode("Hello NIO"));
                        key.interestOps(SelectionKey.OP_READ);
                    }
                    iter.remove();
                }
            }
        }
    }
}
