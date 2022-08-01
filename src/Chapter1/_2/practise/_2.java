package Chapter1._2.practise;

import edu.princeton.cs.algs4.Interval1D;

import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Interval1D[] arr = new Interval1D[1000];
        int pos = 0;

        while (scanner.hasNext()) {
            double start = scanner.nextDouble();
            if (start == -10) break;
            double end = scanner.nextDouble();
            arr[pos] = new Interval1D(start, end);
            pos++;
        }

        System.out.println("en");

        for (int i = 0; i < pos; i++) {
            for (int j = i+1; j < pos; j++) {
                if (arr[i].intersects(arr[j]))
                    System.out.println(arr[i].toString() + " " + arr[j].toString());
            }
        }
    }
}
