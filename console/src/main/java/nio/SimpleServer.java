package nio;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleServer extends Thread {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

//    // 每个client创建一个线程
//    @SneakyThrows
//    @Override
//    public void run() {
//        try {
//            // 参数0 指随机绑定一个可用端口
//            serverSocket = new ServerSocket(0);
//            while (true) {
//                // 阻塞等待客户端连接
//                Socket socket = serverSocket.accept();
//                RequestHandler requestHandler = new RequestHandler(socket);
//                requestHandler.start();
//            }
//        } finally {
//            if (serverSocket != null) serverSocket.close();
//        }
//    }

    // 线程池机制
    @SneakyThrows
    @Override
    public void run() {
        serverSocket = new ServerSocket(0);
        ExecutorService executor = Executors.newFixedThreadPool(12);
        while (true) {
            Socket socket = serverSocket.accept();
            RequestHandler requestHandler = new RequestHandler(socket);
            executor.execute(requestHandler);
        }
    }
}
