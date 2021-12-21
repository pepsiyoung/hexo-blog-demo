package nio;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler extends Thread {
    private final Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        // 简化实现，不做读取直接发送字符串
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("Hello NIO!");
            out.flush();
        }
    }
}
