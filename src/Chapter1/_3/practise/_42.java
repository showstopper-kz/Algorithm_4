package Chapter1._3.practise;

import Chapter1._3.Stack;

public class _42 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        Stack<String> stackCopy = new Stack<>(stack);
        stackCopy.push("4");
        stackCopy.print();
        stack.print();

        stackCopy.pop();
        stackCopy.print();
        stack.print();
    }
}
