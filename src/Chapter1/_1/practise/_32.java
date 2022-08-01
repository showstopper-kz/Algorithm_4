package Chapter1._1.practise;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;

public class _32 {
    public static void main(String[] args) {
        double[] a = {0.93, 2.0, 2.0, 3.0, 5.0, 7.0};
        int[] res = slice(a, 0, 9.3, 10);
        System.out.println(Arrays.toString(res));
        plot(res, 0, 9.3, 10);
    }

    public static int[] slice(double[] a, double l, double r, int N) {
        int[] res = new int[N];
        double interval = (r - l) / N;

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= r && a[i] >= l) {
                double s = (a[i] - l) / interval;
                int ss = (int)s;
                res[ss]++;
            }
        }
        return res;
    }

    public static void plot(int[] res, double l, double r, int N) {
        StdDraw.setYscale(0, 10);
        StdDraw.setPenColor(Color.pink);
        for (int i = 0; i < res.length; i++) {
            StdDraw.filledRectangle(1.0 * i / N, res[i] / 2.0, 0.5/N, res[i] / 2.0 );
        }
    }
}
