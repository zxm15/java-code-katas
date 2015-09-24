package TwoPointers;

/**
 * Created by ZXM on 9/24/15.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note: You can only use constant extra memory.
 */

/**analysis
 * clarificaiton
 * 1. empty input ?
 * throw exception
 *
 * pattern matching:
 * reorder array using constant space usually need swap.
 * the process is to parition the array into two groups:
 * keywords: partition, swap
 * two pointers paritition algo could make one end stable, the other end is not.
 * It fits our problem precisely.
 *
 * algo
 * keep a slow pointer and runner pointer
 * for runner in n
 *  if array[runner] != 0 swap(array, slow++, runner)
 *
 * note that
 * 1. slow will not exceed runner, euqals to it at most
 * 2. if slow < runner, array[slow]  == 0;
 */
public class MoveZeroes {

    public void moveZeroesTwoPointers(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int slow = 0;
        for (int runner = 0; runner < arr.length; runner++) {
            if (arr[runner] != 0) swap(arr, slow++, runner);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        if (index1 != index2) {
            arr[index1] ^= arr[index2];
            arr[index2] ^= arr[index1];
            arr[index1] ^= arr[index2];
        }
    }
}

/**test
 * [0,1,0,2,0]
 * [1,2,0,0,0]
 */

