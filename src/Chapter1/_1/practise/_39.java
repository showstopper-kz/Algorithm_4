package Chapter1._1.practise;

import edu.princeton.cs.algs4.StdRandom;

public class _39 {
    public static void main(String[] args) {
        System.out.println(mock(2000));
    }

    public static double mock(int T) {
        double sum = 0;
        for (int i = 0; i < T; i++) {
            sum += gen(1000000);
        }
        return sum / T;
    }

    public static int gen(int N) {
        int cnt = 0;
        int[] arr = new int[N];
        int[] brr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100000 + StdRandom.uniform(900000);
        }

        for (int i = 0; i < brr.length; i++) {
            brr[i] = 100000 + StdRandom.uniform(900000);
        }

        for (int i = 0; i < arr.length; i++) {
            int res = binarySearch(arr[i], brr, 0, arr.length - 1);
            if (res != -1) cnt++;
        }
        return cnt;
    }
    public static int binarySearch(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > key) return binarySearch(key, a, lo, mid - 1);
        else if (a[mid] < key) return binarySearch(key, a, mid+1 , hi);
        else return mid;
    }
}
