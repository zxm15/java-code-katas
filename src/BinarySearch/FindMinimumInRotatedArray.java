package BinarySearch;

/**
 * Created by zxm on 6/10/15.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 *
 * Analysis:
 * observation 1: if the whole array is sorted, the minimum value is the first one
 * observation 2: if A[s] < A[e], then the array must be sorted.
 * observation 3: the middle pivot will cut the rotated array in half. One of the half is sorted, another one is unsorted
 * observation 4: the minimum value must exist in unsorted half
 *
 * sum up: we want to search the unsorted half for minimum value
 *
 * pseudo code:
 * function findMin(array) {
 *     s = 0, e = array.length;
 *     while (s < e)
 *          if A[s] < A[e] return A[s]
 *          int m = (s + e) / 2;
 *          if A[m] < A[e] e = m;
 *          else if A[m] > A[e] s = m + 1;
 *          else
 *              //ask help from another half
 *              if A[s] < A[m]  //not possible unless right half are all duplicates in which case it is handled at the beginning A[s] < A[e]
 *              else if A[s] > A[m] e = m;
 *              else s++;
 *
 * }
 */
public class FindMinimumInRotatedArray {

    public int findMin(int[] nums) {
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
