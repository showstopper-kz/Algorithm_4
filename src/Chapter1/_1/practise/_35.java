package Chapter1._1.practise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class _35 {
    public static void main(String[] args) {
        double[] a = sidesPrediction();
        for (int i = 1; ; i++) {
            double[] b = mock(i);
            boolean res = compare(a ,b);
            System.out.println(i + " " + compare(a, b));
            if (res) return;
        }
    }
    public static double[] sidesPrediction() {
        int SIDES = 6;
        double[] dist = new double[SIDES * 2 + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i+j] += 1.0;
            }
        }

        for (int i = 2; i <= SIDES * 2; i++)
            dist[i] /= 36.0;
        return dist;
    }

    public static double[] mock(int N) {
        double[] res = new double[13];
        for (int i = 0; i < N; i++) {
            int a = StdRandom.uniform(6) + 1;
            int b = StdRandom.uniform(6) + 1;
            res[a+b] += 1.0;
        }
        for (int i = 0; i < res.length; i++) {
            res[i] /= N;
        }
        return res;
    }
    
    public static boolean compare(double[] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i] - b[i]) > 0.01)
                return false;
        }
        return true;
    }
}
