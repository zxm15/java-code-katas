package Graph;

/**
 * Created by ZXM on 8/7/15.
 */
class ArcNode {
    int label;
    double weight = 0; //in unweight graph, this value is 0;
    ArcNode next = null;
    public ArcNode(int label) {
        this.label = label;
    }
    public ArcNode(int label, int weight) {
        this.label = label;
        this.weight = weight;
    }
}
