package Arrays;

/**
 * Created by zxm on 6/25/15.
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            // if (m == 0 && nums[m] > nums[m + 1] || m == nums.length - 1 && nums[m] > nums[m - 1] || mums[m] > nums[m - 1] && nums[m] > nums[m + 1]) return m;
            if (m > 0 && nums[m - 1] > nums[m]) e = m - 1;
            else if (m < nums.length - 1 && nums[m] < nums[m + 1]) s = m + 1;
            else return m;
        }
        return s;
    }

    //testing
    /*
    nums    exp     act
    [1,2,3] 2       2
    [1,2,3,2] 2     2
    [1]     0       0
    */
}
