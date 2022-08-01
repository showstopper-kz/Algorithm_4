package Chapter1._1.practise;

public class _15 {
    public static int[] histogram(int[] a, int M) {
        int[] count = new int[M];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > M-1) continue;
            count[a[i]]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3};
        int[] res = histogram(a, 4);
        int count = 0;

        for (int i = 0; i < res.length; i++) {
            count += res[i];
        }
        System.out.println(count == a.length);
    }
}
