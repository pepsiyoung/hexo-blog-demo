package nio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class NIODemo {
    public static void main(String[] args) throws IOException, InterruptedException {

//        DemoServer server = new DemoServer();
        ThreadPoolServer server = new ThreadPoolServer();
        server.start();

//        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
////            String res = IOUtils.toString(client.getInputStream(), StandardCharsets.UTF_8);
//
//            DataOutputStream out = new DataOutputStream(client.getOutputStream());
//            out.writeUTF("ddd");
//            out.flush();
//
////            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
////            String input = IOUtils.toString(inputStreamReader);
////            System.out.println("input="+ input);
////
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            bufferedReader.lines().forEach(System.out::println);
//        }


        int count = 0;
        for (int i = 0; i < 99; i++) {
            try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
                PrintWriter os = new PrintWriter(client.getOutputStream());
                os.println("任务:" + i);
                os.flush();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                bufferedReader.lines().forEach(System.out::println);
            }
        }
        System.out.println("end");


    }
}
