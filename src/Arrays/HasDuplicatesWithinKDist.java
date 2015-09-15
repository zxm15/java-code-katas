package Arrays;

import java.util.HashMap;

/**
 * Write a function that is given an array of integers and an integer k.
 * It should return true if and only if there are two distinct indices i and j in the array such that arr[i] = arr[j]
 * and the difference between i and j is at most k.
 */
public class HasDuplicatesWithinKDist {
    /**
     * @param arr containing integers
     * @param k integer suggestion the valid distance
     * @return res boolean true or false
     */

    public static boolean hasDuplicatesWithinKDist(int[] arr, int k) {
        if(k <= 0) return false;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < arr.length; i++) {
            if(!map.isEmpty() && map.containsKey(arr[i]) && i - map.get(arr[i]) + 1 <= k) return true;
            map.put(arr[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] {1,2,3,1,5,4};
        System.out.println(hasDuplicatesWithinKDist(testArr, 3));
        System.out.println(hasDuplicatesWithinKDist(testArr, 4));
        System.out.println(hasDuplicatesWithinKDist(testArr, 5));
    }
}
