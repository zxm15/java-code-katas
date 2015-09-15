package Arrays;

/**
 * Created by zxm on 6/25/15.
 */
public class FindMinInRotatedArray {
    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     */
     /*
    observation 1: cut array in half, at least one half is sorted
    2: the min element always exists in the unsorted half
    3: num[s] < num[e] meaning the substirng between [s, e] is sorted in the context of rotated sorted array
    4: know min in unsorted half, and know how to find the unsorted half in o(1) time, should be binary search alike algorithm
    */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            if (nums[s] < nums[e]) return nums[s];
            int m = (s + e) / 2;
            if (nums[m] < nums[e]) e = m;
            else s = m + 1;
        }
        return nums[s];
    }

    //testing
    /*
    nums    exp     act
    [1]     1       1
    [1,2,3] 1       1
    [2,3,1] 1       1
    [3,1,2] 1       1
    time spent : 18 mins
    */

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Find the minimum element.
     * <p>
     * The array may contain duplicates.
     */
    public int findMinII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            if (nums[s] < nums[e]) break;
            int m = (s + e) / 2;
            if (nums[m] < nums[e]) e = m;
            else if (nums[m] > nums[e]) s = m + 1;
            else {
                if (nums[s] != nums[m]) e = m;
                else s++;
            }
        }
        return nums[s];

    }
}
