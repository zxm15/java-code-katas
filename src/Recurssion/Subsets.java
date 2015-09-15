package Recurssion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

/**
 * Created by zxm on 6/26/15.
 */
public class Subsets {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

     Note:
     Elements in a subset must be in non-descending order.
     The solution set must not contain duplicate subsets.
     For example,
     If nums = [1,2,2], a solution is:

     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        if (nums == null || nums.length == 0) return subsets;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap();
        for (Integer i : nums) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        subsetsWithDup(nums, 0, map, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    private void subsetsWithDup(int[] nums, int index, HashMap<Integer, Integer> map,  ArrayList<Integer> subset, List<List<Integer>> subsets) {
        if (index == nums.length) {
            ArrayList<Integer> list = new ArrayList();
            list.addAll(subset);
            subsets.add(list);
            return;
        }
        if (index > 0 && nums[index - 1] == nums[index])
            subsetsWithDup(nums, index + 1, map, subset, subsets);
        else {
            for (int i = 0; i <= map.get(nums[index]); i++) {
                for (int j = 0; j < i; j++)
                    subset.add(nums[index]);

                subsetsWithDup(nums, index + 1, map, subset, subsets);
                for (int j = 0; j < i; j++)
                    subset.remove(subset.size() - 1);

            }
        }
    }
    /**
     * testing
     * nums         exp         act
     * []           [[]]          [[]]
     * [1]          [[],[1]]    same
     * [1,1,2]      [[],[1],[1,1],[1,1,2],[1,2],[2]] same
     * time spent : 25 mins = 7l + 10c + 8t
     */
}
