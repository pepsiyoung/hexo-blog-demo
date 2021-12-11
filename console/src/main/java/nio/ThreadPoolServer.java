package nio;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolServer extends Thread {

    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

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
