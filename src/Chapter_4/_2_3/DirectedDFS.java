package Chapter_4._2_3;

import Chapter_4._2_2.Digraph;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class DirectedDFS {
    private boolean marked[];

    public DirectedDFS(Digraph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s);
    }

    public DirectedDFS(Digraph g, Iterable<Integer> sources){
        marked = new boolean[g.V()];
        for(int s: sources)
            if(!marked[s]) dfs(g,s);
    }

    public void dfs(Digraph g, int v){
        marked[v] = true;
        for (int w:g.adj(v)) dfs(g,w);
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph G = new Digraph(sc);
        Bag<Integer> sources = new Bag<Integer>();

        DirectedDFS directedDFS = new DirectedDFS(G,2);
        for (int v = 0;v < G.V();v++)
            if(directedDFS.marked(v) ) StdOut.print(v+" ");

        System.out.println();
    }
}
