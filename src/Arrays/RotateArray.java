package Arrays;

/**
 * Created by zxm on 6/25/15.
 */
public class RotateArray {
    /**
     * Rotate an array of n elements to the right by k steps.
     * <p>
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * <p>
     * Note:
     * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * <p>
     * [show hint]
     * <p>
     * Hint:
     * Could you do it in-place with O(1) extra space?
     */

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k <= 0) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) swap(nums, s++, e--);
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

    /*
    testing
    nums    k   exp     act
    [1 2]   1   [2, 1]  [2, 1]
    [1,2,3] 5   [2,3,1] [2,3,1]
    [1]     10  [1]     [1]
    */
}
