package Graph.DifferenceBetweenTreeAndGraph;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * <p>
 * For example:
 * <p>
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * <p>
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * analysis
 * clarification
 * 1. empty input?
 * 2. n <= 0 ?
 * assume all input are valid
 *
 * pattern matching:
 * n nodes, list of edges => graph (objects and pointers)
 * question is to check if this graph is a valid tree => difference between graph and tree
 * tree
 * has one and only one root
 * except for root, has one and only one parent
 * no loop
 * every node must be in the same connected component.
 *
 *
 * examplify
 *  1
 * 2 3
 * from example we could see, for undirected graph, each node in a valid tree could be a root
 * so the root judgement does not work here. so does for parent requirement.
 *
 * pseudo code
 *
 * method 1:
 * create a adjacency list of the graph,
 * dfs to check if there is a loop
 * for loop to check if there is only one connected component.
 *
 * time: o(m) + o(n + e), space: o(n + e)
 *
 * method 2:
 * to detect a cycle in undirected graph, we could use union find
 * to detected a connected component in graph, we could use union find
 *
 * time: o(n) + O(m) + o(n)
 * space : o(n)
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 0) return false;
        int m = edges.length;
        if (m == 0 && n <= 1) return true;
        if (m == 0 && n > 1) return false;
        Map<Integer, GraphNode> graph = new HashMap<>();
        for (int[] edge : edges) {
            for (int i = 0; i < 2; i++) {
                if (! graph.containsKey(edge[i])) {
                    graph.put(edge[i], new GraphNode(edge[i]));
                }
            }
            graph.get(edge[0]).neighbors.add(graph.get(edge[1]));
            graph.get(edge[1]).neighbors.add(graph.get(edge[0]));
        }

        return isValidTree(n, graph);
    }

    private boolean isValidTree(int n, Map<Integer, GraphNode> graph) {
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && graph.containsKey(i)) {
                if (hasCycle(i, graph, visited, -1)) return false;
                else break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) return false;
        }

        return true;
    }

    private boolean hasCycle(int label, Map<Integer, GraphNode> graph, int[] visited, int previous) {
        if (visited[label] == 1) return false;
        if (visited[label] == -1) return true;
        visited[label] = -1;
        for (GraphNode neighbor : graph.get(label).neighbors) {
            if (neighbor.label != previous && hasCycle(neighbor.label, graph, visited, label)) return true;
        }
        visited[label] = 1;

        return false;
    }
}
