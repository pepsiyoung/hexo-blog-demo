package nio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SimpleDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        SimpleServer server = new SimpleServer();
        server.start();

        // 确保先开启server之后再执行下面的代码
        TimeUnit.SECONDS.sleep(1);
        // 模拟了一个简单的客户端
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);
        }
    }
}
