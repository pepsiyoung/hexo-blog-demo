package basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

public class Demo3 {

    public static void main(String[] args) throws ParseException {
//        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date validTime = dateFormat1.parse("2020-03-01");
        Date failureTime = dateFormat1.parse("2022-04-07");

        Date current = new Date();
        int res1 = validTime.compareTo(current);
        int res2 = failureTime.compareTo(current);
        System.out.println(res1 > 0 || res2 < 0);
    }
}
