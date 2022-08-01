package Chapter_4._2_4;

import Chapter_4._2_2.Digraph;
import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

/**
 * 按次序遍历有向图
 */
public class DepthFirstOrder {
    private boolean[] marked;
    //前序
    private Queue<Integer> pre;
    //后序
    private Queue<Integer> post;
    //逆后序(拓扑排序)
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph g) {
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++)
            if (!marked[v]) dfs(g, v);
    }

    public void dfs(Digraph g, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w]) dfs(g, w);
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> getPre() {
        return pre;
    }

    ;

    public Iterable<Integer> getPost() {
        return post;
    }

    public Iterable<Integer> getReversePost() {
        return reversePost;
    }
}
