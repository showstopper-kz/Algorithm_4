package Chapter_4._1_2;

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
    }

    //深度搜索
    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked[w]) dfs(g, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
