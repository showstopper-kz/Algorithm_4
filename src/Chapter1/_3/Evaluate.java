package Chapter1._3;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> opers = new Stack<>();
        Stack<Double> nums = new Stack<>();

        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("q")) {
            String s = sc.next();
            if (s.equals("(")) ;
            else if (
                    s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")
            ) opers.push(s);
            else if (s.equals(")")) {
                double val = nums.pop();
                switch (opers.pop()){
                    case "+": nums.push(nums.pop() + val); break;
                    case "-": nums.push(nums.pop() - val); break;
                    case "*": nums.push(nums.pop() * val); break;
                    case "/": nums.push(nums.pop() / val); break;
                    case "sqrt": nums.push(Math.sqrt(val));
                }
            } else nums.push(Double.parseDouble(s));
        }
        System.out.println(nums.pop());
    }
}
