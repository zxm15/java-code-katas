package Strings;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxm on 11/11/15.
 */
public class FindMedianCharacters {

    public List<Character> findMedian(char[] arr) {
        if (arr == null || arr.length == 0) return new ArrayList<>();
        int n = arr.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            if (! map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        //create inverted index
        Map<Integer, List<Character>> inverted = new HashMap<>();
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (! inverted.containsKey(value)) {
                inverted.put(value, new ArrayList<>());
            }
            List<Character> list = inverted.get(value);
            list.add(key);
        }

        //select median of the number
        int median = selectKthElement(new ArrayList(inverted.keySet()), inverted.size() / 2 + 1);

        return inverted.get(median);
    }

    public int selectKthElement(List<Integer> list, int k) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("The input is empty");
        int index = selectKthElementHelper(list, 0, list.size() - 1, k);
        return list.get(index);
    }

    private int selectKthElementHelper(List<Integer> list, int start, int end, int k) {
//        if (start > end) return -1;
//        int mid = (start + end) / 2;
//        int pivotIndex = partition(list, start, end, mid, k);
//        int leftSize = pivotIndex - start + 1;
//        if (k == leftSize) return pivotIndex;
//        if (k < leftSize) return selectKthElementHelper(list, start, pivotIndex - 1, k);
//        return selectKthElementHelper(list, pivotIndex + 1, end, k - leftSize);

        while (start <= end) {
            int mid = (start + end) / 2;
            int pivotIndex = partition(list, start, end, mid, k);
            int leftSize = pivotIndex - start + 1;
            if (k == leftSize) return pivotIndex;
            if (k < leftSize) end = pivotIndex - 1;
            else {
                start = pivotIndex + 1;
                k -= leftSize;
            }
        }

        return -1;
    }

    private int partition(List<Integer> list, int start, int end, int pivotIndex, int k) {
        int pivot = list.get(pivotIndex);
        swap(list, end, pivotIndex);
        int leftStart = start;
        for (int i = start; i < end; i++) {
            if (list.get(i) <= pivot) {
                swap(list, i, leftStart++);
            }
        }

        swap(list, leftStart, end);
        return leftStart;

    }

    private void swap(List<Integer> list, int i, int j) {
        if (i != j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}
