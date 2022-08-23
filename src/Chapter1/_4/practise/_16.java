package Chapter1._4.practise;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class _16 {
    public static int getMin(int[] a) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            min = Math.min(Math.abs(a[i] - a[i-1]), min);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = In.readInts("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/1Kints.txt");
        System.out.println(getMin(a));
    }
}
