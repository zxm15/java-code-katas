package Graph.UnionFind;

/**
 * Created by ZXM on 10/7/15.
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * <p>
 * For example:
 * <p>
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * <p>
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */

public class GraphValidTreeUnionFind {
    //if the edges could contains the duplicates, then we will need a hashmap to determine if a edge has been shown up before.
    public boolean validTree(int n, int[][] edges) {
        if (n < 0) return false;
        int m = edges.length;
        if (m == 0 && n <= 1) return true;
        if (m == 0 && n > 1) return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            //there are three cases for this
            //if edges[0] and edges[1] share the same father, then it contains loop
            //1. edges[0] == edges[1] self loop, we want to return false and our union does so
            //else
            //  2 one of them is the father, since [[1,0],[0,1]] is not allowed, then it must be a loop
            // 3 none of them is the father, since no duplicate edge, then it must be a loop.
            if (uf.union(edge[0], edge[1]))
                return false; //note that there are many cases such as [[1,0],[0,1]] and duplicate edges, union find cannot handle well,
            //but in this quesiton, we were given the condition "you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.""
        }
        //it is possible that there are more than one connected component in the graph
        int father = uf.compressFind(0);
        for (int i = 1; i < n; i++) {
            if (father != uf.compressFind(i)) return false;
        }

        return true;
    }
}
