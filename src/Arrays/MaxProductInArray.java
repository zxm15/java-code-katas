package Arrays;

/**
 * Created by zxm on 6/25/15.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProductInArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int globalMax = Integer.MIN_VALUE, prevMax = 1, prevMin = 1;
        for (Integer i : nums) {
            int currMax = Math.max(i, Math.max(i * prevMax, i * prevMin));
            int currMin = Math.min(i, Math.min(i * prevMax, i * prevMin));
            globalMax = Math.max(globalMax, currMax);
            prevMax = currMax;
            prevMin = currMin;
        }
        return globalMax;
    }

    /*
    testing
    nums    exp     act
    [1,2,3] 6       6
    [-2,3-2] 12     12
    [-1,-2,-9,-6]

    time spent: 15 mins
    */
}
