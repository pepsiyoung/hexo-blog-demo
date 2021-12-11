package nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDemo {
    public static void main(String[] args) throws IOException {

//        NIOServer server = new NIOServer();
//        server.start();
//
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(() -> {
//                try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
//                    PrintWriter os = new PrintWriter(client.getOutputStream());
//                    os.println("任务:NIO");
//                    os.flush();
//                } catch (IOException ignored) {
//
//                }
//            });
//            thread.start();
//        }

//
//        for (int i = 0; i < 3; i++) {
//            try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
//                PrintWriter os = new PrintWriter(client.getOutputStream());
//                os.println("任务:NIO");
//                os.flush();
//            }
//        }

    }
}
