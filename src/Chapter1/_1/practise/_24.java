package Chapter1._1.practise;
import java.util.Scanner;

public class _24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(gcd(a, b));
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        System.out.println(a+" "+b);
        int r = a % b;
        return gcd(b, r);
    }
}