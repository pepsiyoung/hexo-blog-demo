
import com.alibaba.testable.core.annotation.MockInvoke;
import com.pepsiyoung.web.service.MockService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class DemoInnerClassTest {

    public static class Mock {
        // 放置Mock方法的地方
        @MockInvoke(targetClass = MockService.class)
        private String substring(int a, int b) {
            return "sub_string";
        }
    }

    @Test
    public void demo1() {
//        MockService mockService = new MockService();
//        String res = mockService.substring(0, 5);
//        System.out.println(res);

        String startTime = LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).toString();
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(startTime);
        System.out.println(endTime);
    }

    @Test
    public void demo2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        list = list.stream().skip(1).limit(100).collect(Collectors.toList());
//        System.out.println(list);

        int count = 0;
        int pagesize = 20;
        int totalPage = ( count - 1) / pagesize + 1;
        System.out.println(totalPage);
    }

    @Test
    public void threeNum() {
        int[] nums = {0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (num.length < 3) return ans;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                if (num[i] + num[left] + num[right] == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(num[i], num[left], num[right])));
                    while (num[left] == num[left + 1] && left + 1 < right) left++;
                    while (num[right] == num[right - 1] && right - 1 > left) right--;
                    left++;
                    right--;
                } else if (num[i] + num[left] + num[right] < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}