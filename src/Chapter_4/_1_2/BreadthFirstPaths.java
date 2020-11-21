package Chapter_4._1_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph g,int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

    }
    //广度搜索
    private void bfs(Graph g,int s){
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w : g.adj(v)){
                edgeTo[w] = v;
                marked[w] = true;
                queue.add(w);
            }
        }

    }

    public boolean hasPathTo(int v) {return marked[v];}
    //返回背包
    public Iterable<Integer> pathTo(int v){
        if( !hasPathTo(v) ) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s;x = edgeTo[x]) path.push(s);
        path.push(s);
        return path;
    }
}
