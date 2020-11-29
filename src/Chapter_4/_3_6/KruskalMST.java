package Chapter_4._3_6;

import Chapter_4._3_2.Edge;
import Chapter_4._3_2.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * kruskal方法生成无向图最小树
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<>();

        for (Edge edge : G.edges())
            pq.insert(edge);

        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V()-1){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            //若v，w两点在union结构中连通
            if(uf.connected(v,w)) continue;
            //将v与w连通
            uf.union(v,w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {return mst;}
}
