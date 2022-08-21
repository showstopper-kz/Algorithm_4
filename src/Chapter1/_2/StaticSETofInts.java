package Chapter1._2;

import Chapter1._1.BinarySearch;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;
    public  StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        if (a.length == 0) return -1;
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            if (a[mid] > key) hi = mid - 1;
            if (a[mid] < key) lo = mid + 1;
        }
        return -1;
    }

    private int howMany(int key) {
        int[] res = BinarySearch.rank(key, a);
        return res[1] - res[0] + 1;
    }

    public static void main(String[] args) {
        int[] a = new int [] {1, 23, 3, 4, 4, 3};
        StaticSETofInts s = new StaticSETofInts(a);
        System.out.println(s.howMany(3));
    }
}
