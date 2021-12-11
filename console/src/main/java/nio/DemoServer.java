package nio;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer extends Thread {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @SneakyThrows
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}
