package Chapter_4._1_6;

import Chapter_4._1_2.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class CC {
    //判断顶点是否被访问
    private boolean[] marked;
    //第i个的值代表是第几个子图
    private int[] id;
    private int count;
    public CC(Graph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for(int s = 0;s < g.V();s++){
            if(!marked[s]){
                dfs(g,s);
                count++;
            }
        }
    }

    public void dfs(Graph g,int v){
        marked[v] = true;
        id[v] = count;
        for (Integer w : g.adj(v)) {
            if(!marked[w]) dfs(g,w);
        }
    }

    public boolean connected(int v,int w){return id[v] == id[w];}
    public int id(int v){return id[v];}
    public int count(){return count;}

    public static void main(String[] args) {
        Graph g = new Graph(new Scanner(System.in));
        CC cc = new CC(g);
        //连通分量数
        int M = cc.count;
        StdOut.println(M+" components");

        Bag<Integer>[] components;
        components = new Bag[M];
        for(int i=0;i<M;i++){
            components[i] = new Bag<Integer>();
        }
        for (int v=0;v<g.V();v++){
            components[cc.id[v]].add(v);
        }
        for(int i =0;i<M;i++){
            for(int v:components[i])
                StdOut.print(v+" ");
            System.out.println();
        }
        Cycle cycle=new Cycle(g);
        System.out.println(cycle.getHasCycle());
        System.out.println(g.E());
    }
}
