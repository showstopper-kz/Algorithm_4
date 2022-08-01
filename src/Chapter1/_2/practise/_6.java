package Chapter1._2.practise;

import java.util.Arrays;

public class _6 {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "BCA";

        boolean res = (s1.length() == s2.length()) && (s1.concat(s1).indexOf(s2) >= 0);
        System.out.println(res);
    }
}
