package Graph;

import java.util.*;

/**
 * Created by ZXM on 8/7/15.
 * For directed graph, find the topological sort
 */
public class TopSort {
    //MyGraph graph = new MyGraph(10, GraphType.DIRECTED_UNWEIGHT);
    //detect if we could achieve top sort, this is to ask if there is a cycle in the graph
    //if not, retuen true; else return false;
    public boolean canHaveTopSort(MyGraph g) {
        return ! g.hasCycle();
    }

    /**
     * time complexity O(V + E)
     * @param g
     * @return List of vertices in toplogical order
     */
    public List<Integer> getTopSortByBFS(MyGraph g) {
        List<Integer> res = new ArrayList<Integer>();
        if (! canHaveTopSort(g)) return res;
        int[] in = getIndegrees(g);
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        Vertex[] vertices = g.getVertices();
        while (! queue.isEmpty()) {
            int index = queue.poll();
            res.add(index);
            for (ArcNode node = g.getFirstNeighbor(vertices[index]); node != null; node = g.getNextNeighbor(node)) {
                if (in[node.label] > 0) {
                    if (--in[node.label] == 0) {
                        queue.offer(node.label);

                    }

                }
            }
        }

        return res;
    }

    private int[] getIndegrees(MyGraph g) {
        int[] in = new int[g.getNum()];
        Vertex[] vertices = g.getVertices();
        for (int i = 0; i < in.length; i++) {
            for (ArcNode node = g.getFirstNeighbor(vertices[i]); node != null; node = g.getNextNeighbor(node)) {
                in[node.label]++;
            }
        }

        return in;
    }

    public List<Integer> getTopSortByDFS(MyGraph g) {
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        Vertex[] vertices = g.getVertices();
        for (int i = 0; i < vertices.length; i++) {
            if (! set.contains(i)) {
                dfs(g,vertices, i, set, res);
            }
        }

        return res;
    }

    private void dfs(MyGraph g, Vertex[] vertices, int i, Set<Integer> set, List<Integer> res) {
        if (set.contains(i)) return;
        set.add(i);
        for (ArcNode node = g.getFirstNeighbor(vertices[i]); node != null; node = g.getNextNeighbor(node)) {
            dfs(g, vertices, node.label, set, res);
        }
        res.add(0, i);

    }
}
