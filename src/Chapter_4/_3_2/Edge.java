package Chapter_4._3_2;

public class Edge {
    private final int v;
    private final int w;
    private double weigtht;

    public Edge(int v, int w, double weigtht) {
        this.v = v;
        this.w = w;
        this.weigtht = weigtht;
    }

    public double weight(){ return weigtht; }
    public int either(){ return v; }
    public int other(int vertex){//获得边上另一个顶点
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent  edge");
    }

    public int compareTo(Edge that){//比较this权重是否大于所给that的权重
        if      (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else                                    return  0;
    }

    public String toString()//打印边
    { return String.format( "%d-%d %2.f", v, w, weigtht); }
}
