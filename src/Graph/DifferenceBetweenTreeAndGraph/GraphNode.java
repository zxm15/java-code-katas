package Graph.DifferenceBetweenTreeAndGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXM on 10/7/15.
 */
public class GraphNode {
    public int label;
    public List<GraphNode> neighbors;
    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
