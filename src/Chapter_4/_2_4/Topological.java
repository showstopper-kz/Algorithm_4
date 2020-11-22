package Chapter_4._2_4;

import Chapter_4._2_2.Digraph;

public class Topological {
    private Iterable<Integer> order;
    public Topological(Digraph g){
        DirectedCycle cyclefinder = new DirectedCycle(g);
        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(g);
            order = dfs.getReversePost();
        }
    }
    public Iterable<Integer> order(){ return order;}
    public boolean isDAG(){return order != null;}
}
