package Chapter_4._3_4;

import Chapter_4._3_2.Edge;
import Chapter_4._3_2.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
    private boolean marked[];
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();//取出队列最小的项
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge edge : G.adj(v)) {
            if (!marked[edge.other(v)]) pq.insert(edge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge edge : mst) {
            weight += edge.weight();
        }
        return weight;
    }
}
