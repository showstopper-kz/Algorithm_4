package Chapter1._4;

import Chapter1._3.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class DoubingTest {
    public static double timeTrail(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        Queue<Double> queue = new Queue<>();

        double max = 0.0;

        for (int i = 1000; i <= 8000; i += i) {
            double time = timeTrail(i);
            time = Math.log(time);
            if (i == 8000) max = time;
            queue.enqueue(time);
            System.out.println(time);
        }

        int N = queue.size();
        StdDraw.setXscale(0, N+1);
        StdDraw.setYscale(0, max+1);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(Color.orange);

        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, queue.dequeue() );
        }
        StdDraw.show();
    }
}
