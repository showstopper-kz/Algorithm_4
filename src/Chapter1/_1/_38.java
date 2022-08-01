package Chapter1._1;

import edu.princeton.cs.algs4.In;

public class _38 {
    public static void main(String[] args) {
        In in = new In("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/src/Chapter1/_1/largeW.txt");
        //In in = new In("/home/kirin/largeW.txt");
        int[] whitelist = in.readAllInts();

        in = new In("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/src/Chapter1/_1/largeT.txt");
        //in = new In("/home/kirin/largeT.txt");
        int[] trans = in.readAllInts();

        long start = System.currentTimeMillis();
        for (int i = 0; i < trans.length; i++) {
            int res = binarySearch(trans[i], whitelist, 0, whitelist.length - 1);
            //int res = bruteSearch(trans[i], whitelist);
            if (res == -1) System.out.println(trans[i]);
        }
        long end = System.currentTimeMillis();

        System.out.println("cost" + (end - start) + "million seconds");
    }

    public static int binarySearch(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > key) return binarySearch(key, a, lo, mid - 1);
        else if (a[mid] < key) return binarySearch(key, a, mid+1 , hi);
        else return mid;
    }

    public static int bruteSearch(int key, int []a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }
}
