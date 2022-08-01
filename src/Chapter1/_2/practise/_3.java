package Chapter1._2.practise;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Scanner;

public class _3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.square(50, 50, 50);

        Interval2D[] arr = new Interval2D[N];

        for (int i = 0; i < N; i++) {
            int x1 = min + (int)(Math.random() *  (max - min));
            int x2 = min + (int)(Math.random() *  (max - min));

            while (x1 == x2)
                x1 = min + (int)(Math.random() *  (max - min));

            int y1 = min + (int)(Math.random() *  (max - min));
            int y2 = min + (int)(Math.random() *  (max - min));

            while (y1 == y2)
                y1 = min + (int)(Math.random() *  (max - min));

            arr[i] = new Interval2D(new Interval1D(Math.min(x1, x2), Math.max(x1, x2)),
                                    new Interval1D(Math.min(y1, y1), Math.max(y1, y2)));

            arr[i].draw();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i].intersects(arr[j]))
                    System.out.println(arr[i].toString() + " " + arr[j].toString());
            }
        }
    }
}
