package Chapter1._1.practise;

public class _14 {
    public static void main(String[] args) {
        for (int i = 1; i < 10000000; i++) {
            int res = log2N(i);
            if (Math.pow(2, res) > i || Math.pow(2, res+1) < i)
                System.out.println("False: " + i + " " +res);
        }
        System.out.println("All Success!");
    }

    public static int log2N(int a) {
        int counter = 0;
        while (a > 0) {
            counter++;
            a /= 2;
        }
        return counter-1;
    }
}
