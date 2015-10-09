package Arrays;

/**
 * Find the pair with the max difference, the larger number should be
 * behind the smaller number
 *
 */

/**
 * analysis
 * clarification:
 * 1. empty input
 * exception
 * 2. integer overflow
 * if smaller than Integer.MIN_VALUE, MIN
 * if larger than Integer.MAX_VALUE, return MAX
 *
 * iterate through array once, keep tracking the smallest number before index i
 * get the difference between A[i] and min.
 * compare it with global max
 */
public class MaxDifferenceWithLargerNumberBehindSmallerNumber {
    public int findMaxDifference(int[] A) {
        if (A == null || A.length == 0) throw new IllegalArgumentException("The array is empty");
        int min = A[0], globalMax = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            int diff = 0;
            if (A[i] > 0 && min < 0 && Integer.MAX_VALUE + min <= A[i]) {
                diff = Integer.MAX_VALUE;
            } else if (A[i] < 0 && min > 0 && Integer.MIN_VALUE + min >= A[i]) {
                diff = Integer.MIN_VALUE;
            } else {
                diff = A[i] - min;
            }
            min = Math.min(min, A[i]);
            globalMax = Math.max(globalMax, diff);
        }

        return globalMax;
    }

}
