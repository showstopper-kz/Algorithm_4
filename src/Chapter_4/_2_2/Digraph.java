package Chapter_4._2_2;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = E;
        this.adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public int V(){return V;}
    public int E(){return E;}

    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int V){return adj[V];}

    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v=0;v < V;v++)
            for(int w:adj[v])
                R.addEdge(w,v);
        return R;
    }

}
