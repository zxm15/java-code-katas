package Graph;

import java.util.*;

/**
 * Created by ZXM on 8/7/15.
 * Use adjacency list to represent a graph
 */
public class MyGraph {



    private int num; //num of vertices in graph
    private Vertex[] vertices;
    private GraphType type;

    public MyGraph(int num, GraphType type){
        this.num = num;
        vertices = new Vertex[num];
        for (int i = 0; i < num; i++) {
            vertices[i] = new Vertex(i);
        }
        this.type = type;
    }


    public void addNeighbor (Vertex start, Vertex end, GraphType type) {

    }

    //dfs traversal
    public List<Integer> dfs() {
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        if (vertices == null || vertices.length == 0) return res;
        for (int i = 0; i < vertices.length; i++) {
            dfs(i, visited, res);
        }
        return res;
    }

    private void dfs(int index, Set<Integer> visited, List<Integer> res) {
        if (visited.contains(index)) return;
        visited.add(index);
        res.add(index);
        for (ArcNode node = getFirstNeighbor(vertices[index]); node != null; node = getNextNeighbor(node)) {
            dfs(node.label, visited, res);
        }

    }

    //bfs
    public List<Integer> bfs() {
        List<Integer> res = new ArrayList<Integer>();
        boolean[] visited = new boolean[num];
        if (vertices == null || vertices.length == 0) return res;
        for (int i = 0; i < vertices.length; i++) {
            if (! visited[i]) {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                visited[i] = true;
                while (! queue.isEmpty()) {
                    Vertex v = vertices[queue.poll()];
                    res.add(v.label);
                    for (ArcNode node = getFirstNeighbor(v); node != null; node = getNextNeighbor(node)) {
                        int index = node.label;
                        if (! visited[index]) {
                            visited[index] = true;
                            queue.offer(index);
                        }
                    }
                }
            }
        }

        return res;
    }

    public boolean hasCycle() {
        switch(type) {
            case DIRECTED_WEIGHT:   return hasCycleDirectedGraph();
            case DIRECTED_UNWEIGHT: return hasCycleDirectedGraph();
            case UNDIRECTED_WEIGHT: return hasCycleUndirectedGraph();
            case UNDIRECTED_UNWEIGHT: return hasCycleUndirectedGraph();

        }
        return false;
    }

    private boolean hasCycleUndirectedGraph() {
        if (vertices == null || vertices.length == 0) return false;
        int[] visited = new int[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            if (visited[i] == 0) {
                if (hasCycleUnDirectedGraphHelper(i, visited, -1)) return true;
            }
        }

        return false;
    }

    private boolean hasCycleUnDirectedGraphHelper(int index, int[] visited, int parent) {
        if (visited[index] == 1) return false;
        if (visited[index] == -1) return true;
        visited[index] = -1;
        for (ArcNode node = getFirstNeighbor(vertices[index]); node != null; node = getNextNeighbor(node)) {
            if (node.label != parent) {
                if (hasCycleUnDirectedGraphHelper(node.label, visited, index)) return true;
            }

        }
        visited[index] = 1;
        return false;
    }

    private boolean hasCycleDirectedGraph() {
        if (vertices == null || vertices.length == 0) return false;
        int[] visited = new int[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            if (visited[i] == 0) {
                if (hasCycleDirectedGraphHelper(i, visited)) return true;
            }
        }

        return false;
    }

    private boolean hasCycleDirectedGraphHelper(int index, int[] visited) {
        if (visited[index] == 1) return false;
        if (visited[index] == -1) return true;
        visited[index] = -1;
        for (ArcNode node = getFirstNeighbor(vertices[index]); node != null; node = getNextNeighbor(node)) {
            if (hasCycleDirectedGraphHelper(node.label, visited)) return true;
        }
        visited[index] = 1;
        return false;
    }

    protected ArcNode getFirstNeighbor(Vertex v) {
        return v.neighbors;
    }

    protected ArcNode getNextNeighbor(ArcNode arc) {
        return arc.next;
    }

    protected Vertex[] getVertices() {
        return vertices;
    }

    public int getNum() {
        return num;
    }
}
