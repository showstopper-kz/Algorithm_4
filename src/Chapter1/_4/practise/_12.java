package Chapter1._4.practise;


import edu.princeton.cs.algs4.BinarySearch;

public class _12 {
    public static void printEqPari(int[] a, int[] b) {

        Integer pre = Math.max(a[a.length-1], b[b.length-1]) + 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == pre) continue;
            if (BinarySearch.rank(a[i], b) != -1) {
                System.out.println(a[i]);
            }
            pre = a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 4, 5};
        int[] b = new int[]{3, 4, 5, 5, 5, 5};
        printEqPari(a, b);
    }
}
