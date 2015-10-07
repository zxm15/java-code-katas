package Graph.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZXM on 10/7/15.
 */
public class UnionFind {
    Map<Integer, Integer> map = new HashMap<>();
    public UnionFind(int n) {
        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }
    }

    public int compressFind(int i) {
        if (i == map.get(i)) return i;
        int father = compressFind(map.get(i));
        map.put(i, father);
        return father;
    }

    public boolean union(int x, int y) {
        int fatherX = compressFind(x);
        int fatherY = compressFind(y);
        if (fatherX != fatherY) {
            map.put(fatherX, fatherY);
            return false;
        }

        return true; //indicate they were not in the same set
    }
}
