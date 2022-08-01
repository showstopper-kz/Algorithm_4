package Chapter1._1.practise;

public class _5 {
    private static boolean range(double a, int start, int end) {
        return a > start && a < end;
    }

    public static void main(String[] args) {
        double x = 0.1;
        double y = 0.1;
        boolean res = range(x, 0, 1) && range(y, 0, 1);
        System.out.println(res);
    }
}
