package Chapter_4._2_2;


import edu.princeton.cs.algs4.Bag;

import java.util.Scanner;

/**
 * construct the directed graph
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Digraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);//v -> w
        E++;
    }

    public Iterable<Integer> adj(int V) {
        return adj[V];
    }

    //将图反向
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj[v])
                R.addEdge(w, v);
        return R;
    }

}
