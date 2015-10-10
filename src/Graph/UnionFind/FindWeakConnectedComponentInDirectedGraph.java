package Graph.UnionFind;

import Graph.DifferenceBetweenTreeAndGraph.GraphNode;

import java.util.*;

/**
 * Created by ZXM on 10/10/15.
 * Find the number Weak Connected Component in the directed graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 */
public class FindWeakConnectedComponentInDirectedGraph {
    public List<List<Integer>> findWeakComponent(List<GraphNode> graphNodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (graphNodes == null || graphNodes.size() == 0) return res;
        UnionFind uf = new UnionFind(graphNodes.size());
        for (int i = 0; i < graphNodes.size(); i++) {
            GraphNode a = graphNodes.get(i);
            for (GraphNode neighbor : a.neighbors) {
                uf.union(a.label, neighbor.label);
            }
        }
        //generate the result list from the uf map
        Map<Integer, List<Integer>> componentMap = new HashMap<>();
        for (Integer vertex : componentMap.keySet()) {
            int father = uf.compressFind(vertex);
            if (!componentMap.containsKey(father))
                componentMap.put(father, new ArrayList<>());
            List<Integer> component = componentMap.get(father);
            component.add(vertex);
        }
        for (List<Integer> component : componentMap.values()) {
            Collections.sort(component);
            res.add(component);
        }

        return res;
    }

}
