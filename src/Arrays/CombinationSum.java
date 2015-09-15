package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 4/15/2015.
 */
public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> findCombinationSum(int sum, int size, int maxNum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int seriesSum = size * (size + 1) / 2;
        if (sum > maxNum * size - seriesSum || sum < seriesSum) return res;
        findCombinationSumHelper(sum, size, 0, maxNum, new ArrayList<Integer>(), res);
        return res;
    }

    public static void findCombinationSumHelper(int sum, int size, int lastNum, int maxNum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (sum == 0 && size == 0) {
            res.add((ArrayList) list.clone());
            return;
        }
        if (sum <= 0 || size <= 0 || sum < size) return;
        for (int i = lastNum + 1; i + size - 1 < maxNum; i++) {
            list.add(i);
            findCombinationSumHelper(sum - i, size - 1, i, maxNum, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = findCombinationSum(15, 3, 10);
        for (ArrayList<Integer> list : res) {
            for (Integer i : list) System.out.print(i + "-");
            System.out.println();
        }
    }

    /**
     * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

     Ensure that numbers within the set are sorted in ascending order.


     Example 1:

     Input: k = 3, n = 7

     Output:

     [[1,2,4]]

     Example 2:

     Input: k = 3, n = 9

     Output:

     [[1,2,6], [1,3,5], [2,3,4]]

     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinationSumHelper(k, n, 1, new ArrayList<Integer>(), res);
        return res;
    }

    public void combinationSumHelper(int k, int n, int i, ArrayList<Integer> list, List<List<Integer>> res) {
        if (n == 0 && k == 0) {
            ArrayList<Integer> temp = new ArrayList();
            temp.addAll(list);
            res.add(temp);
            return;
        }
        if (k <= 0 || n <= 0 || i > 9) return;
        //contain i in combos
        list.add(i);
        combinationSumHelper(k - 1, n - i, i + 1, list, res);
        list.remove(list.size() - 1);
        combinationSumHelper(k, n, i + 1, list, res);
    }

    /*
    testing
    k   n   expect  act
    0   0   [[]]    [[]]
    0   1   []      []
    3   7   [1,2,4] [1 2 4]
    3   3   []      []
    time spent: 27mins, several typo mistakes
    */

}
