package Recurssion;

import java.util.*;

/**
 * Created by ZXM on 11/30/15.
 */
public class NestedListSum {

    public int calNestedListSum(Iterable iterable) {
        if (iterable == null) return 0;
        int[] res = new int[] {0};
        helper(iterable.iterator(), 1, res);
        return res[0];
    }

    private void helper(Iterator iterator, int depth, int[] sum) {
        if (! iterator.hasNext()) return;
        Object data = iterator.next();
        if (data instanceof Iterable) {
            helper(((Iterable) data).iterator(), depth + 1, sum);

        } else if (data instanceof Integer) {
            sum[0] += ((Integer) data) * depth;
        }
        helper(iterator, depth, sum);
    }

    public static void main(String[] args) {
        List list = new LinkedList<>();
        list.add(1);
        list.add(new LinkedList(Arrays.asList(2, new ArrayList(Arrays.asList(4, 5)))));
        list.add(1);
        list.add(new HashSet(Arrays.asList(6,7,8)));
        NestedListSum solution = new NestedListSum();
        System.out.println(solution.calNestedListSum(list));

    }
}
