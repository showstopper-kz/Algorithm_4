package Chapter_4._2_5;

import Chapter_4._2_2.Digraph;
import Chapter_4._2_3.DirectedDFS;

public class TransitiveClosure {
    private DirectedDFS[] all;
    TransitiveClosure(Digraph g){
        all = new DirectedDFS[g.V()];
        for (int v=0;v<g.V();v++){
            all[v] = new DirectedDFS(g,v);
        }
    }

    boolean reachable(int v,int w){
        return all[v].marked(w);
    }
}
