package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NIODemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        NIOServer server = new NIOServer();
        server.start();
        // 线程sleep500毫秒确保server端先执行
        TimeUnit.MILLISECONDS.sleep(500);

        // 客户端需要发送的消息 server端收到bye就断开连接
        List<String> msgList = Arrays.asList("WWW", "AMD", "YES");

        try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
            InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 8888);
            SocketChannel socketChannel2 = SocketChannel.open(address);

            // 创建一个线程模拟发送客户端消息
            Thread sendMsgThread = new Thread(() -> {
                msgList.forEach(msg -> {
                    try {
                        socketChannel2.write(ByteBuffer.wrap(msg.getBytes()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });
            sendMsgThread.start();

            // 接收server端发来的消息
            int bytesRead;
            // 参数设置9 为了简化实现 不考虑半包、粘包问题
            ByteBuffer buf = ByteBuffer.allocate(9);
            while ((bytesRead = socketChannel2.read(buf)) != -1) {
                System.out.println("client:" + new String(buf.array(), 0, bytesRead, StandardCharsets.UTF_8));
                buf.clear();
            }
        }
    }
}
