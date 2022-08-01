package Chapter1._1.practise;

public class _19 {
    public static void main(String[] args) {
        long[] arr = new long[1000];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 1000; i++) {
            Fibonacci.FWithArr(i, arr);
            System.out.println(i + " " +arr[i]);
        }
    }
}

class Fibonacci {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static void FWithArr(int N, long[] arr) {
        arr[N] = arr[N-1] + arr[N-2];
    }
}
