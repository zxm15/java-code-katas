package Graph.ToplogicalSort;

/**
 * Created by ZXM on 10/6/15.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**analysis
 * clarification
 * empty input?
 * return true;
 *
 * pattern matching:
 * course -> node in graph
 * pair -> directed edge in graph
 * finish course in some order -> toplogical sort
 * can have top sort -> has cycle in graph?
 *
 * method 1:
 * 1. create a graph from given
 * 2. traverse the graph to determine if there is a cycle in path
 *
 * time max(o(m + n), o(n + e))
 * method 2:
 * I was trying to use union find.
 * But it is more useful when detecting a cycle in undirected graph.
 *
 * method 3:
 * can we know if the tree contains cycle free edges info?
 * we could tell if they could form a tree or not
 * but we do not know if they contains a circle.
 * because tree has more restrications than having a cycle.
 * see review for more details about the difference between tree and graph
 */


public class CheckIfCanFinishAllCourses {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        int m = prerequisites.length;
        Map<Integer, GraphNode> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (! graph.containsKey(pair[1])) {
                graph.put(pair[1], new GraphNode(pair[1]));
            }
            GraphNode node = graph.get(pair[1]);
            if (! graph.containsKey(pair[0])) {
                graph.put(pair[0], new GraphNode(pair[0]));
            }
            node.neighbors.add(graph.get(pair[0]));
        }

        return ! hasCycle(graph, numCourses);
    }

    private boolean hasCycle(Map<Integer, GraphNode> graph, int num) {
        if (graph.isEmpty()) return false;
        int[] visited = new int[num];
        for (int i = 0; i < num; i++) {
            if (visited[i] == 0 && graph.containsKey(i)) {
                if (hasCycleDFS(i, graph, visited)) return true;
            }
        }

        return false;
    }

    private boolean hasCycleDFS(int label, Map<Integer, GraphNode> graph, int[] visited) {
        if (visited[label] == 1) return false;
        if (visited[label] == -1) return true;
        visited[label] = -1;
        GraphNode node = graph.get(label);
        for (GraphNode neighbor : node.neighbors) {
            if (hasCycleDFS(neighbor.label, graph, visited)) return true;
        }
        visited[label] = 1;

        return false;
    }

}
