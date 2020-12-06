package Chapter_4._3_4;

import Chapter_4._3_2.Edge;
import Chapter_4._3_2.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
    private Edge[] edgeTo;//连接顶点与最小生成树的边
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;//带索引的优先队列

    private PrimMST(EdgeWeightedGraph G){

        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];

        for (int v=0;v < G.V();v++)
            distTo[v] = Double.POSITIVE_INFINITY;//正无穷

        pq = new IndexMinPQ<Double>(G.V());
        distTo[0]= 0.0;
        pq.insert(0,0.0);

        while (!pq.isEmpty())
            visit(G,pq.delMin());
    }

    private void visit(EdgeWeightedGraph G,int v){
        marked[v] = true;
        for (Edge edge : G.adj(v)) {

            int w = edge.either();
            if(marked[w]) continue;

            if(edge.weight() < distTo[w]){
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if(pq.contains(w))  pq.changeKey(w,distTo[w]);
                else                pq.insert(w,distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        Bag<Edge> edges = new Bag<>();

        for (Edge edge : edgeTo)
            edges.add(edge);
        return edges;
    }

}
