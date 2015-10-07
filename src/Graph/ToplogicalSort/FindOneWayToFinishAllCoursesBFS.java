package Graph.ToplogicalSort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ZXM on 10/7/15.
 */
public class FindOneWayToFinishAllCoursesBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, GraphNode> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        int[] res = new int[numCourses];
        for (int[] pair : prerequisites) {
            if (! graph.containsKey(pair[1])) {
                graph.put(pair[1], new GraphNode(pair[1]));
            }
            GraphNode node = graph.get(pair[1]);
            if (! graph.containsKey(pair[0])) {
                graph.put(pair[0], new GraphNode(pair[0]));
            }
            node.neighbors.add(graph.get(pair[0]));
            indegrees[pair[0]]++;
        }

        Queue<GraphNode> queue = new LinkedList<>();

        //add the nodes with indegree == 0
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                if (graph.containsKey(i)) queue.offer(graph.get(i));
                else queue.offer(new GraphNode(i));
            }
        }
        int index = 0;
        while (! queue.isEmpty()) {
            GraphNode node = queue.poll();
            res[index++] = node.label;
            for (GraphNode neighbor : node.neighbors) {
                if (--indegrees[neighbor.label] == 0) {
                    queue.offer(neighbor);
                }
            }

        }

        return index == numCourses ? res : new int[0];

    }
}
