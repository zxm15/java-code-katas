package Arrays;

/**
 * Created by Gavin on 4/15/2015.
 */
public class WiggleSort {
    public static void wiggleSort(int[] arr) {
        if(arr.length <= 1) return;
        boolean prevSmaller = true;
        for(int i = 1; i < arr.length; i += 1) {
            if(prevSmaller) {
                if(arr[i-1] > arr[i]) swap(arr, i-1, i);
                prevSmaller = false;
            }else {
                if(arr[i] > arr[i-1]) swap(arr, i-1, i);
                prevSmaller = true;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if(i == j) return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,2,4,6,7,8, 2};
        wiggleSort(arr);
        for(Integer i : arr) System.out.print(i + "-");
    }
}
