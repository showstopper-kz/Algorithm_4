package Chapter1._2;
import edu.princeton.cs.algs4.*;

public class Interval2DTest {
    public static void main(String[] args) {
        double xlo = 0;
        double ylo = xlo;
        double xhi = 100.0;
        double yhi = xhi;

        Interval1D intervalx = new Interval1D(xlo, xhi);
        Interval1D intervaly = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(intervalx, intervaly);
        box.draw();

        StdDraw.setPenRadius(0.005);
        
        Counter c = new Counter("Counter");
        for (int i = 0; i < 1000; i++) {
            double x = Math.random();
            double y = Math.random();

            Point2D point = new Point2D(x, y);
            if (!box.contains(point)) c.increment();
            else point.draw();
        }
    }
}
