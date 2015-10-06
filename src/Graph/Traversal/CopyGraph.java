package Graph.Traversal;

/**
 * Created by ZXM on 10/6/15.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**analysis
 * clarification
 * 1. given graph is null?
 * return null;
 * 2. directed graph or undirected graph?
 * it could be both
 * 3. is the graph connected?
 * not necessary
 * 4. label is unique?
 * yes.
 * pattern matching
 * nature is traversal;
 * use dfs;
 *
 * time O(v + e) space O(v + e)
 */

class GraphNode {
    int label;
    List<GraphNode> neighbors;
    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
public class CopyGraph {
    public List<GraphNode> copyGraph(List<GraphNode> graphNodes) {
        List<GraphNode> res = new ArrayList<>();
        if (graphNodes.isEmpty()) {
            return res;
        }
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        for (GraphNode node : graphNodes) {
            if (! visited.containsKey(node)) {
                res.add(dfs(node, visited));

            }
        }

        return res;
    }

    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
        if (map.containsKey(node)) return map.get(node);
        GraphNode copied = new GraphNode(node.label);
        map.put(node, copied);
        for (GraphNode neighbor : node.neighbors) {
            copied.neighbors.add(dfs(neighbor, map));
        }

        return copied;
    }
}

/**test
 * []   []
 * [1], [1]
 * [1] 1-1
 *
 * 1-2, 2-1
 *
 */
