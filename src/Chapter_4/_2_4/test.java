package Chapter_4._2_4;

import Chapter_4._2_2.Digraph;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph digraph = new Digraph(sc);
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        Iterable<Integer> cycle = directedCycle.cycle();
        for (Integer integer : cycle) {
            System.out.print(integer+" ");
        }
    }
}
