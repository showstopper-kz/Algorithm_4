package Chapter_4._1_2;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;//起点

    public DepthFirstPaths(Graph g,int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
    }

    //深度搜索
    private void dfs(Graph g,int v){
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if( !marked[w] ){
                edgeTo[w] = v;
                dfs(g,w);
            }
        }
    }

    public boolean hasPathTo(int v){return marked[v];}

    public Iterable<Integer> pathTo(int v){
        if( !hasPathTo(v) ) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s;x = edgeTo[x]) path.push(s);
        path.push(s);
        return path;
    }
}
