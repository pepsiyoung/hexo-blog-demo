package basic;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream1.forEach(System.out::println);

        Stream<Double> stream2 = Stream.generate(Math::random).limit(2);
        stream2.forEach(System.out::println);

        Pattern pattern = Pattern.compile("&");
        Stream<String> stringStream = pattern.splitAsStream("a&b&c&d");
        stringStream.forEach(System.out::println);
    }
}
