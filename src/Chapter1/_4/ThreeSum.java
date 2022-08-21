package Chapter1._4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j]  == -a[k])
                        cnt++;
                }
            }
        }
        return cnt;
    }

    public static void countTime(int testSize) {
        int[] a = In.readInts("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/"+testSize+"Kints.txt");
        Stopwatch stopwatch = new Stopwatch();
        int res = count(a);
        double timeCost = stopwatch.elapsedTime();
        System.out.println(res + " triples " + "time: " + timeCost);
    }

    public static void main(String[] args) {
        countTime(1);
        countTime(2);
        countTime(4);
        countTime(8);
    }
}
