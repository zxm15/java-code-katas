package Graph.ToplogicalSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXM on 10/6/15.
 */
class GraphNode {
    int label;
    List<GraphNode> neighbors;
    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }

}
