package Graph.ToplogicalSort;

/**
 * Created by ZXM on 10/6/15.
 */

/**
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * For example:
 * <p>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * <p>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * <p>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**analysis
 * follow up with the check question
 * find one possible top sort
 * pattern matching-> dfs || bfs
 *
 */

public class FindOneWayToFinishAllCourses {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return rawSort(numCourses);
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

        int[] res = findTopSort(graph, numCourses);
        reverse(res);
        return res;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    private int[] rawSort(int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i;
        }
        return res;
    }

    private int[] findTopSort(Map<Integer, GraphNode> graph, int num) {
        int[] res = new int[num];
        if (graph.isEmpty()) {
            return rawSort(num);
        }
        int[] visited = new int[num];
        int[] index = new int[1];
        for (int i = 0; i < num; i++) {
            if (visited[i] == 0) {
                if (graph.containsKey(i)) {
                    if (hasCycleDFS(i, graph, visited, index, res)) return new int[0];
                } else res[index[0]++] = i;
            }
        }

        return res;
    }

    private boolean hasCycleDFS(int label, Map<Integer, GraphNode> graph, int[] visited, int[] index, int[] res) {
        if (visited[label] == 1) return false;
        if (visited[label] == -1) return true;
        visited[label] = -1;
        GraphNode node = graph.get(label);
        for (GraphNode neighbor : node.neighbors) {
            if (hasCycleDFS(neighbor.label, graph, visited, index, res)) return true;
        }
        visited[label] = 1;
        res[index[0]++] = label;

        return false;
    }
}
