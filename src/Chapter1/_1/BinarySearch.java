package Chapter1._1;

import java.util.Arrays;

public class BinarySearch {
    public static int[] rank(int key, int[] a) {
        int start=-1, end = -1;

        int lo = 0;
        int hi = a.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == key &&((mid == 0) || (a[mid-1] != key))) {start=mid; break;}
            else if (a[mid] >= key) hi = mid - 1;
            else if (a[mid] < key) lo = mid + 1;
        }

        lo = 0;
        hi = a.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == key &&((mid == a.length-1) || (a[mid+1] != key))) {end=mid; break;}
            else if (a[mid] > key) hi = mid - 1;
            else if (a[mid] <= key) lo = mid + 1;
        }
        int[] res = {start, end-start+1};
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 6, 12};
        System.out.println(Arrays.toString(rank(3, a)));
    }
}
