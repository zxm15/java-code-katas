package Arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zxm on 6/25/15.
 *
 */
public class ContainsDuplicates {
    //Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet();
        for (Integer i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
    /*
    testing
    array   expected    actual
    1       false       false
    1 2 1   true        true
    1 2 3   false       false
    Time spent 7 mins
    */

    //Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int last = map.get(nums[i]);
                if (i - last <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    //testing
    /*
    edge case: nums=[] false;
    nums    exp     act
    []      false   f
    1       f       f
    1 2 1, 1 f      f
    1 2 1, 2 t      t
    1 2 3  3 f      f
    time spend 10 mins
    */
}
