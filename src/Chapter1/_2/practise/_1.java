package Chapter1._2.practise;

import edu.princeton.cs.algs4.StdDraw;

public class _1 {

    public static void main(String[] args) {
        double[][] pos = new double[1000][2];

        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);

        for (int i = 0; i < 1000; i++) {
            pos[i][0] = Math.random();
            pos[i][1] = Math.random();
            StdDraw.point(pos[i][0], pos[i][1]);
        }

        double min = Double.MAX_VALUE;

        for (int i = 0; i < 1000; i++) {
            for (int j = i+1; j < 1000; j++) {
                double length = Math.sqrt(Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
                if (length < min) min = length;
            }
        }
        System.out.println(min);
    }
}
