package Chapter_4._2_5;

import Chapter_4._2_2.Digraph;
import Chapter_4._2_4.DepthFirstOrder;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;
    public KosarajuSCC(Digraph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        //取得反向图的逆后序排列
        DepthFirstOrder order = new DepthFirstOrder(g.reverse());
        for(int s:order.getReversePost())
            if (!marked[s])
            {dfs(g,s);count++;}
    }

    private void dfs(Digraph g,int v){
        marked[v] = true;
        id[v] = count;
        for(int w:g.adj(v)){
            if(!marked[w]) dfs(g,w);
        }
    }

    public boolean stronglyConnected(int v,int w){return id[v]==id[w];}

    //return:顶点v在第几个连通分量
    public int id(int v){return id[v];}

    public int getCount() { return count; }
}
