package Chapter1._2.practise;

import edu.princeton.cs.algs4.Counter;

import java.util.Scanner;

public class _9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int key = sc.nextInt();

        int i = 0;
        while (sc.hasNextInt())  {
            arr[i++] = sc.nextInt();
        }

        Counter counter = new Counter("test");
        int res = binarySearch(key, arr, 0, arr.length-1, counter);
        System.out.println(res + " Search keys:" + counter.tally());
    }

    public static int binarySearch(int key, int[]a, int lo, int hi, Counter counter) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        counter.increment();
        if (a[mid] > key) binarySearch(key, a, lo, mid - 1, counter);
        else if (a[mid] < key) binarySearch(key, a, mid + 1, hi, counter);
        return mid;
    }
}
