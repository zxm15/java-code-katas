package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXM on 9/14/15.
 */
public class ZigZagListIterator {

    int m; //the number of the lists
    int n; //the longest length of lists
    int i = 1; //the current row
    int j = 1; //the current col
    int count; //the number of remaining integers
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    boolean zig = true;
    public ZigZagListIterator(List<Integer> v1, List<Integer> v2) {
        count = v1.size() + v2.size();
        lists.add(new ArrayList<Integer>(n + 2)); //top buffer
        if (! v1.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(0);
            temp.addAll(v1);
            temp.add(0);
            lists.add(temp);
        }
        if (! v2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(0);
            temp.addAll(v2);
            temp.add(0);
            lists.add(temp);
        }
        lists.add(new ArrayList<Integer>(n + 2)); //bottom buffer
        m = lists.size() - 1;
        n = Math.max(v1.size(), v2.size()) + 1;
    }

    public int next() {
        int res = 0;
        boolean found = false;
        while (! found) {
            if (zig) {
                while (i < m && j > 0 && j >= lists.get(i).size() - 1) {
                    i++;
                    j--;
                }
                //check boundaries
                if (i == m || j == 0) {
                    zig = false;
                    j++;
                } else {
                    res = lists.get(i++).get(j--);
                    // i++;
                    // j--;
                    found = true;
                }

            } else {
                while (i > 0 && j < n && j >= lists.get(i).size() - 1) {
                    i--;
                    j++;
                }
                //check bourdaries
                if (i == 0 || j == n) {
                    zig = true;
                    i++;
                } else {
                    res = lists.get(i--).get(j++);
                    // i--;
                    // j++;
                    found = true;
                }
            }
        }


        count--;
        return res;
    }

    public boolean hasNext() {
        return count > 0;
    }


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
