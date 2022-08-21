package Chapter1._4;


import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class TwoSumFast {
    public static int  count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (BinarySearch.rank(-a[i], a) > i)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts("");
        System.out.println(count(a));
    }
}
