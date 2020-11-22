package Chapter_4._2_4;

import Chapter_4._2_2.Digraph;
import Chapter_4._2_3.DirectedDFS;

import java.util.Stack;

/**
 * 有向图检测环
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph g){
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        for(int v=0;v < g.V();v++)
            if(!marked[v]) dfs(g,v);
    }

    public void dfs(Digraph g, int v){
        onStack[v] = true;
        marked[v] = true;
        for(int w:g.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){ return cycle != null; }
    public Iterable<Integer> cycle(){ return cycle; }
}
