package Chapter1._1.practise;

public class _20 {
    public static void main(String[] args) {
        System.out.println(lnN(1));
    }

    public static double lnN(int n) {
        if (n == 1) return Math.log(1);
        return Math.log(n) + lnN(n -1);
    }
}
