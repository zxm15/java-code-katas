package BinarySearch;

/**
 * Given an array, there is a peak,
 * the first part is in increasing order
 * the second part is in descending order
 * e.g.
 * 1,2,5,9,7,6,1
 * given an value, check if it exists
 *
 */

/**analysis
 * clarification:
 * empty input?
 * false
 * could the first element to be the largest?
 * yes
 * could the last element to be the largest?
 * yes
 * duplicate values?
 * no. because if there is duplicates in arr, we cannot find the largest element in O(logn) time
 * pattern matching
 * it has to be o(logn) time => binary search => sorted array,
 * it has two sorted array.
 * 1. find the largest element or smallest element using bs
 * 2. find the element in left and right using bs
 */
public class FindElementInPartialSortedArray {
    public boolean findElement(int[] arr, int value) {
        if (arr == null || arr.length == 0) return false;
        int maxIndex = findMaxValue(arr);
        if (value > arr[maxIndex] || value < Math.min(arr[0], arr[arr.length - 1])) return false;
        return findElementHelper(arr, 0, maxIndex, value, true) || findElementHelper(arr, maxIndex + 1, arr.length - 1, value, false);
    }

    private int findMaxValue(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (m > 0 && arr[m - 1] > arr[m]) e = m - 1;
            else if (m < e && arr[m + 1] > arr[m]) s = m + 1;
            else return m;
        }

        return s;
    }

    private boolean findElementHelper(int[] arr, int s, int e, int value, boolean isAscending) {
        while (s < e) {
            int m = (s + e) / 2;
            if (arr[m] == value) return true;
            if (arr[m] > value) {
                if (isAscending) e = m;
                else s = m + 1;
            } else {
                if (isAscending) s = m + 1;
                else e = m;
            }
        }

        return arr[s] == value;
    }
}
