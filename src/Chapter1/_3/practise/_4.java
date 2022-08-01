package Chapter1._3.practise;

import Chapter1._3.Stack;

import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (!sc.hasNext("quit")) {
            s = sc.next();
        }
        System.out.println(check(s));

    }

    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' )
                stack.push(c);
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == '(' && top != ')') || (c == '{' && top != '}') || (c == '[' && top != ']'))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
