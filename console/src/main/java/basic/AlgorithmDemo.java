package basic;

import sort.OrderDelay;

import java.util.Stack;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class AlgorithmDemo {

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        queue.put(new OrderDelay("AAA", TimeUnit.NANOSECONDS.convert(6, TimeUnit.SECONDS)));
        queue.add(new OrderDelay("BBB", TimeUnit.NANOSECONDS.convert(2, TimeUnit.SECONDS)));

        while (!queue.isEmpty()) {
            queue.take().print();
        }
    }


    /**
     * 括号匹配
     * String str = "}(])[{(}([[}])}]))})]]({{(])";
     * System.out.println(isValid(str));
     */
    public static boolean isValid(String s) {
        // write code here
        int len = s.length();
        if(!s.contains(")") && !s.contains("]") && !s.contains("}")) return false;
        if ((len & 1) == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ("{[(".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                Character popValue = stack.pop();
                if (popValue == '(' && c != ')') return false;
                if (popValue == '[' && c != ']') return false;
                if (popValue == '{' && c != '}') return false;
            }
        }
        return true;
    }

}
