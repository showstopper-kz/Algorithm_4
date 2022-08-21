package Chapter1._4.practise;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

public class _14 {
    public static int FourSum(String filePath) {
        int[] a = In.readInts(filePath);
        int cnt = 0;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if (BinarySearch.rank(-a[i]-a[j]-a[k], a) > -1)
                        cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
