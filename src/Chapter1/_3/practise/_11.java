package Chapter1._3.practise;

import Chapter1._3.Stack;

import java.util.Scanner;

public class _11 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        for (char c : s.toCharArray()) {
            if ( c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '-') {
                stack.push(-(stack.pop() - stack.pop()));
            } else if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.parseInt(""+c));
            }
        }
        System.out.println(stack.pop());
    }
}
