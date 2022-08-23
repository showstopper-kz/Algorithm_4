package Chapter1._4.practise;

import java.util.Arrays;

public class _17 {
    public static int getMax(int[] a) {
        int[] arr = Arrays.copyOf(a, a.length);
        Arrays.sort(arr);
        return arr[a.length-1] - a[0];
    }
    public static void main(String[] args) {
        
    }
}
