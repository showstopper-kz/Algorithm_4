package Chapter_4._3_2;

import edu.princeton.cs.algs4.Bag;

import java.util.Scanner;

/**
 * 带权无向图
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(Scanner sc) {
        this(sc.nextInt());
        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            int either = sc.nextInt();
            int other = sc.nextInt();
            double weight = sc.nextFloat();
            Edge edge = new Edge(either, other, weight);
            addEdge(edge);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    //返回图中所有边
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int i = 0; i < V; i++)
            for (Edge edge : adj[i]) {
                if (edge.other(i) > i) b.add(edge);
            }
        return b;
    }

}
