package BucketSort;

import java.util.Arrays;
/**
 * Created by ZXM on 9/25/15.
 * Given an array of citations (each citation is an non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have got at least h citations each, and the other N - h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them has received 3, 0, 6, 1, 5citations respectively, since the researcher has 3 papers that have got at least 3 citations and the remaining two have got no more than 3 citations, his h-index is 3.

 Note: if there are several possible values for h, the maximum one is taken as the h-index.

 */

/**analysis
 * clarification:
 * 1. negative values?
 * all non-neg values;
 * 2. empty input?
 * return 0;
 *
 * pattern matching:
 * the nature of the problems is to compare a value with every other one in the array
 * compare => sort
 *
 * method 1:
 * sort array,
 * then find the min
 *
 * 6,5,6,1
 * 1,5,6,6
 * 0,1,2,3
 * O(nlogn) time
 *
 *
 *
 * method 2:
 * observe that all possible h-index are in [0, n]
 * brute force:
 * for j in [0, n]
 *  iterate the array to find how many values are larger or equal to it.
 *
 * O(n^2) time
 * optimization:
 * reduce the time to check if a number is a valid h-index
 * bucket sort
 * each bucket contains the number of appearances of the value in array.
 * number of values >= j is in a range[prevSum, prevSum + bucket[j]];
 *
 * O(n) time and O(n) space.
 *
 */
public class HIndex {

    public int findHIndex(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length + 1;
        int[] buckets = new int[n + 2];
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) buckets[arr[i]]++;
            else buckets[arr[n + 1]]++;
        }
        int prev = buckets[arr[n + 1]];
        for (int i = n; i > 0; i--) {
            if (i >= prev && i <= prev + buckets[i]) {
                hIndex = i;
                break;
            }
        }

        return hIndex;
    }

    public int findHIndexSortedArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        return findHIndexSortedArray(arr);
    }

    private int findHIndexSortedArrayHelper(int[] arr) {
        return 0;
    }

}

/**test
 *   3,3,0,6,1,5,9
 * 0,0,0,0,0,0,0,0,0
 * 1,1,0,2,0,1,1,0,1
 *                 0
 */
