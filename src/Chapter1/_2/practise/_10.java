package Chapter1._2.practise;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Scanner;

public class _10 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = sc.nextInt();

        VisualCounter visualCounter = new VisualCounter(n, max);
        while (sc.hasNextLine()) {
            String s = sc.next();
            System.out.println(s);
            if (s.equals("+")) {
                visualCounter.increase();
            } else if (s.equals("-")) {
                visualCounter.decrease();
            } else {
                throw new RuntimeException("wrong operators");
            }
        }
    }
}

class VisualCounter {
    int N;
    int max;

    int plotCount;
    int cnt;

    public VisualCounter(int n, int max) {
        N = n;
        this.max = max;
        cnt = 0;
        StdDraw.setXscale(0, n + 1);
        StdDraw.setYscale(0, max + 1);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
    }

    public void increase() throws Exception {
        this.plotCount++;
        ifOutofCounts();
        this.cnt++;
        if (cnt > max) cnt = max;
        StdDraw.point(plotCount, cnt);
    }

    public void decrease() throws Exception {
        plotCount++;
        ifOutofCounts();
        this.cnt--;
        if (this.cnt < 0) cnt = 0;
        StdDraw.point(plotCount, cnt);
    }

    private void ifOutofCounts() throws Exception {
        if (this.plotCount > N)
            throw new Exception("you have achieved the max operation counts");
    }
}
