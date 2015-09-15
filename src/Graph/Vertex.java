package Graph;

/**
 * Created by ZXM on 8/7/15.
 */
class Vertex {
    int label;
    ArcNode neighbors = null; //a linkedlist of arcnodes
    public Vertex(int label) {
        this.label = label;
    }
}
