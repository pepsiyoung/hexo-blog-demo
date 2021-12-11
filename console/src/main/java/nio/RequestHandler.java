package nio;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class RequestHandler extends Thread {
    private final Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        int random = ThreadLocalRandom.current().nextInt(5, 15);
        TimeUnit.SECONDS.sleep(random);
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String str = in.readLine();
                System.out.println(Thread.currentThread().getName() + "服务端收到:" + str);
//                out.println("Hello world!" + str);
//                out.flush();
            }
        }
    }
}
