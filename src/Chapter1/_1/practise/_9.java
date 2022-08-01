package Chapter1._1.practise;

public class _9 {
    public static void main(String[] args) {
        System.out.println(3 + "ss");
    }

    private static String toBinary(int a) {
        String res = "";

        while (a > 0) {
            // n only can be 0 or 1
            res += a % 2;

            a /= 2;
        }

        return res;
    }
}
