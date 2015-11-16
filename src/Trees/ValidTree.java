package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZXM on 11/16/15.
 * The key is to find the number of the root == 1, it is the same with 3
 * it does not contain loop? there are two cases: 1. root == 0 2. for a node, there is more than one parent.
 * it cannot be a forest => iterate through all the nodes, if there are more than 1 nodes that is not a child node, it is a forest
 * for a tree node, it cannot have more than one parent => store Map<child, parent></child,>
 *
 * If it is a forest, then there will be more than one root. could combine them
 *
 * combine above analysis, we could use a map to solve the problem
 * assume for an edge[0][1] 0 is the parent and 1 is the child.
 *
 *
 *
 */
public class ValidTree {

    public boolean isValidTree(int m, int[][] edges) {
        int n = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            if (! map.containsKey(edge[1])) {
                map.put(edge[1], edge[0]);
            } else {
                if (map.get(edge[1]) != edge[0]) return false;
            }


        }

        int count = n;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) count--;
        }

        return count == 1;


    }

}
