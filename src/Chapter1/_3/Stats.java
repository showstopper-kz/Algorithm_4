package Chapter1._3;

import edu.princeton.cs.algs4.Bag;

import java.util.Scanner;

public class Stats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bag<Double> bag = new Bag<>();

        while (sc.hasNextDouble())
            bag.add(sc.nextDouble());

        int N = bag.size();
        double mean = 0;

        for (Double aDouble : bag) {
            mean += aDouble;
        }
        mean /= N;

        double stan = 0;
        for (Double aDouble : bag) {
            stan += (aDouble - mean) * (aDouble - mean);
        }

        stan = Math.sqrt(stan / (N-1));
        System.out.println("mean is:" + mean);
        System.out.println("stan is:" + stan);
    }

}
