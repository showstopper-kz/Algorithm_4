package Chapter_4._1_6;

import Chapter_4._1_2.Graph;

/**
 * 判断是否有环
 */
public class Cycle {
    private boolean []marked;
    private boolean hasCycle;
    public Cycle(Graph g){
        marked = new boolean[g.V()];
        for(int s=0;s<g.V();s++){
            if(!marked[s])
                dfs(g,s,s);
        }
    }

    public boolean getHasCycle() {
        return hasCycle;
    }

    public void dfs(Graph g, int v, int u){
        marked[v] = true;
        for(int w:g.adj(v)){
            if(!marked[w]) dfs(g,w,v);
            else if(w != u) hasCycle = true;
        }
    }
}
