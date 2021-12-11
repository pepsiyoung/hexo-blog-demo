package nio;

import lombok.SneakyThrows;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class NIOServer extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            // 注册到Selector，并说明关注点
            SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // 阻塞等待就绪的Channel，这是关键点之一
                int selectCount = selector.select();
                System.out.println("selectCount=" + selectCount);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                System.out.println(selectedKeys.size());
            }
        }
    }
}


//public class NIOServer extends Thread {
//    public void run() {
//        try (Selector selector = Selector.open();
//             ServerSocketChannel serverSocket = ServerSocketChannel.open();) {// 创建Selector和Channel
//            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
//            serverSocket.configureBlocking(false);
//            // 注册到Selector，并说明关注点
//            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
//            while (true) {
//                selector.select();// 阻塞等待就绪的Channel，这是关键点之一
//                Set<SelectionKey> selectedKeys = selector.selectedKeys();
//                Iterator<SelectionKey> iter = selectedKeys.iterator();
//                while (iter.hasNext()) {
//                    SelectionKey key = iter.next();
//                    // 生产系统中一般会额外进行就绪状态检查
//                    sayHelloWorld((ServerSocketChannel) key.channel());
//                    iter.remove();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
//        try (SocketChannel client = server.accept();) {          client.write(Charset.defaultCharset().encode("Hello world!"));
//        }
//    }
//}

//首先，通过 Selector.open() 创建一个 Selector，作为类似调度员的角色。
//然后，创建一个 ServerSocketChannel，并且向 Selector 注册，通过指定 SelectionKey.OP_ACCEPT，告诉调度员，它关注的是新的连接请求。
//注意，为什么我们要明确配置非阻塞模式呢？这是因为阻塞模式下，注册操作是不允许的，会抛出 IllegalBlockingModeException 异常。
//Selector 阻塞在 select 操作，当有 Channel 发生接入请求，就会被唤醒。
//在 sayHelloWorld 方法中，通过 SocketChannel 和 Buffer 进行数据操作，在本例中是发送了一段字符串。
