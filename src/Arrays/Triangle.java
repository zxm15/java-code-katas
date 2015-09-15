package Arrays;

import java.util.ArrayList;
import java.util.List;


public class Triangle {
    /**
     * Created by zxm on 6/26/15.
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     * <p>
     * For example, given the following triangle
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     */

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        //initializaiton
        for (int i = 0; i < n; i++) dp[i] = triangle.get(n - 1).get(i);
        //calculate dp
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
    /**
     * testing
     * 4,1,8,3
     * 7,6,10
     * 9,10,
     * 11
     *
     * [[1]] 1  1
     * [[1], [-2, 3]] -1 -1
     */

    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     * <p>
     * For example, given numRows = 5,
     * Return
     * <p>
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) return res;

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList();
            int first = 0;
            for (int j = 0; j < i; j++) {
                int second = res.get(i - 1).get(j);
                list.add(first + second);
                first = second;
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    /**
     * Given an index k, return the kth row of the Pascal's triangle.
     * <p>
     * For example, given k = 3,
     * Return [1,3,3,1].
     * <p>
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < rowIndex + 1; i++) {
            int second = 0;
            for (int j = i - 1; j >= 0; j--) {
                int first = res.get(j);
                res.set(j, first + second);
                second = first;
            }
            res.add(0, 1);
        }
        return res;
    }
}

