package BinarySearch;

/**
 * Created by ZXM on 10/21/15.
 * 问题：给一个有序数组（不含重复），返回任意一个数字，这个数字的值和它的数组下标相等。.鏈枃鍘熷垱鑷�1point3acres璁哄潧
 * follow up: 如果含有重复数字怎么办？. 1
 */

/**analysis
 * brute force:O(n)
 * lead to think o(logn) + sorted = binary search
 *
 * -1,2,4,5,6
 * 0,1,2,3,4
 *
 * 0, 0,0,1,2
 * 0, 1,2,3,4
 *
 *
 *
 *
 */
public class MagicIndex {
    public int findMagicIndexWithoutDup(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (arr[m] == m) return m;
            if (arr[m] < m) s = m + 1;
            else e = m;
        }

        return arr[s] == s ? s : -1;
    }

    public int findMagicIndexWithDup(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        return findMagincIndexWithDupHelper(arr, 0, arr.length - 1);
    }

    private int findMagincIndexWithDupHelper(int[] arr, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == mid) return mid;
//        if (arr[mid] > mid) {
//            int res = findMagincIndexWithDupHelper(arr, start, mid - 1);
//            if (res != -1) return res;
//            return findMagincIndexWithDupHelper(arr, arr[mid], end);
//        } else {
//            int res = findMagincIndexWithDupHelper(arr, mid + 1, end);
//            if (res != -1) return res;
//            return findMagincIndexWithDupHelper(arr, start, arr[mid]);
//        }

//        combine above beatiful logic, we could get following
//        combine 1 and 4, 2 and 3
        int res = findMagincIndexWithDupHelper(arr, start, Math.min(mid - 1, arr[mid]));
        if (res != -1) return res;
        return findMagincIndexWithDupHelper(arr, Math.max(arr[mid], mid + 1), end);

    }

}
