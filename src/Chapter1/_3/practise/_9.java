package Chapter1._3.practise;

import Chapter1._3.Stack;

import java.util.Scanner;

public class _9 {
    public static void main(String[] args) {
       Stack<String> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();

        for (char c : res.toCharArray()) {
            if (c == ' ')  continue;
            else if (c == ')') {
                String b = stack.pop();
                String op = stack.pop();
                String a = stack.pop();
                stack.push("(" + a + " " + op + " " + b + ")");
            } else {
                stack.push(""+c);
            }
        }
        System.out.println(stack.pop());
    }
}
