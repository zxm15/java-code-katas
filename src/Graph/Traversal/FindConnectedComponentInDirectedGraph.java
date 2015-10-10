package Graph.Traversal;

/**
 * Created by ZXM on 10/10/15.
 * Find the number connected component in the undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected component (or just component) of an undirected graph
 * is a subgraph in which any two vertices are connected to each other by paths,
 * and which is connected to no additional vertices in the supergraph.)
 */

import java.util.*;

/**analysis
 *
 * clarification
 * empty graph?
 * return empty list
 *
 * It is easy to solve using bfs and dfs
 *
 */
public class FindConnectedComponentInDirectedGraph {
    public List<List<Integer>> dfs(List<GraphNode> graphNodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (graphNodes == null || graphNodes.size() == 0) return res;
        Set<GraphNode> visited = new HashSet<>();
        for (int i = 0; i < graphNodes.size(); i++) {
            if (! visited.contains(graphNodes.get(i))) {
                List<Integer> component = new ArrayList<>();
                dfsHelper(graphNodes.get(i), visited, component);
                Collections.sort(component);
                res.add(component);
            }
        }

        return res;
    }

    private void dfsHelper(GraphNode node, Set<GraphNode> visited, List<Integer> list) {
        if (visited.contains(node)) return;
        list.add(node.label);
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            dfsHelper(neighbor, visited, list);
        }
    }


    public List<List<Integer>> bfs(List<GraphNode> graphNodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (graphNodes == null || graphNodes.size() == 0) return res;
        Set<GraphNode> visited = new HashSet<>();

        for (int i = 0; i < graphNodes.size(); i++) {
            GraphNode node = graphNodes.get(i);
            if (visited.contains(node)) continue;
            Queue<GraphNode> queue = new LinkedList<>();
            List<Integer> component = new ArrayList<>();
            queue.offer(node);
            visited.add(node);
            while (! queue.isEmpty()) {
                node = queue.poll();
                component.add(node.label);
                for (GraphNode neighbor : node.neighbors) {
                    if (! visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            Collections.sort(component);
            res.add(component);

        }

        return res;
    }
}
