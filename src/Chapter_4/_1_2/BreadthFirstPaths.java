package Chapter_4._1_2;

import edu.princeton.cs.algs4.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph g,int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g,s);
    }

    //广度搜索
    private void bfs(Graph g,int s){
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : g.adj(v)){
                edgeTo[w] = v;
                marked[w] = true;
                queue.enqueue(w);
            }
        }
    }

    public boolean hasPathTo(int v) {return marked[v];}

    //返回s到v的最短路径
    public Iterable<Integer> pathTo(int v){
        if( !hasPathTo(v) ) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s;x = edgeTo[x]) path.push(s);
        path.push(s);
        return path;
    }
}
