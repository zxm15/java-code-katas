package Deque;

/**
 * Created by ZXM on 9/22/15.
 * Given an nums of n integer with duplicate number,
 * and a moving window(size k),
 * move the window at each iteration from the start of the nums,
 * find the maximum number inside the window at each moving.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**analysis
 * clarification:
 * 1. empty input or k <= 0
 * throw exception
 *
 * pattern matching
 * window => two pointers
 * max of a range of number => heap
 * O(nk) time and O(k) space
 *
 * note that it is a fixed size window and we insert at one end, delete from another end.
 * only deque could maintain the arrival order and make insertion and deletion in O(1) time.
 * But how to find max value?
 * Inspired from the minStack, we only store the value larger than last one.
 * A tricky part is to start with kth element
 *
 * pseudo code
 * i = k
 *
 * for (; i < n; i++) {
 *     if (deque.isEmpty()) {
 *         init(deque, arr, i, k);
 *     } else if (deque.peekFirst() < max) deque.offerFirst(nums[i + 1]);
 *
 *     int max = Math.max(deque.peekLast(), deque.peekFirst());
 *     deque.pollLast();
 *
 * }
 */
public class SlidingWindowMax {

    public List<Integer> findSlidingWindowMax(int k, int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) return res;
        Deque<Integer> deque = new ArrayDeque<>();
        int i = Math.min(k - 1, nums.length - 1);
        for (; i < nums.length; i++) {
            if (deque.isEmpty()) {
                for (int j = i; j > Math.max(i - k, -1); j--) {
                    if (! deque.isEmpty() && deque.peekLast() > nums[j]) continue;
                    deque.offerLast(nums[j]);
                }
            } else {
                if (deque.peekFirst() <= nums[i]) deque.offerFirst(nums[i]);
            }
            res.add(Math.max(deque.peekFirst(), deque.peekLast()));
            int lastIndex = Math.max(0, i - k + 1);
            if (nums[lastIndex] == deque.peekLast()) deque.pollLast();
        }

        return res;
    }
 }

/**test
 * nums        k       exp     act
 * [1,2,3]      1       1,2,3   1,2,3
 * [1,2,3]      2       2,3     2,3
 * [1,2,3]      4       3       3
 */
