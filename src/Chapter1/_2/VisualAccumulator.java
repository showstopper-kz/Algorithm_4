package Chapter1._2;

import edu.princeton.cs.algs4.*;

import java.awt.*;

public class VisualAccumulator {
    double total;
    int N;
    Accumulator accumulator;
    public VisualAccumulator() {
        this.accumulator = new Accumulator();
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(0, 1.0);
        StdDraw.setPenRadius(0.005);
    }

    public void addValue(double val) {
        this.accumulator.addDataValue(val);
        System.out.println(mean());
        N++;
        StdDraw.setPenColor(Color.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(N, mean());
    }

    public double mean() {
        return this.accumulator.mean();
    }

    public static void main(String[] args) {
        VisualAccumulator visualAccumulator = new VisualAccumulator();
        for (int i = 0; i < 10000; i++) {
            double x = Math.random();
            visualAccumulator.addValue(x);
        }
    }
}
