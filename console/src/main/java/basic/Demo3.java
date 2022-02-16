package basic;

import java.util.Stack;

public class Demo3 {

    public static void main(String[] args) {
        String str = "}(])[{(}([[}])}]))})]]({{(])";

//        System.out.println(3 & 1);
        System.out.println(isValid(str));
    }

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
