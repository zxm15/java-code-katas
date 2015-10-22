package BinarySearch;

/**
 * Created by ZXM on 10/22/15.
 * 有一个很长的list<pair<int, int> > 第一个int 的这个node的序号，第二个int 是这个node 的weight。 写一个函数返回node的序号， 比如：
 * (2, 3)->(3, 5)->(1, 7). 那么返回2的概率是（3／15）， 3的概率是：（5／15），1 的概率
 */

import java.util.List;
import java.util.Random;

/**analysis
 * key word is random seletor which reminds me how to generate a random range by using given
 * random selector. The key for that problem is to ignore the vlaues you do not want.
 *
 * However, in this question, we can use a fresh new idea.
 * brute force is to store all the values together in an array and gereate a random inde
 * question:
 * do we really need to store all the values?
 * we can have an imaginary array which stores all the values and dups together.
 * then how do we know which value it is at the index
 * 1. iterate through the list and index - weight O(n) time and O(1) space
 * 2. store both accumulated weights and key two arrays.since the accumulated weight is a sorted array, use binary search to find the insertion pos
 * O(logn) time and O(n) space
 */

class Pair {
    int value;
    int weight;
    public int (int v, int f) {
        value = v;
        weight = f;
    }

}
public class RandomNumberSelector {
    public int randomSelectWithConstantSpace(List<Pair> list) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("The input is empty");
        int totalWeight = 0;
        for (Pair pair : list)
            totalWeight += pair.weight;
        Random rand = new Random();
        int num = rand.nextInt(totalWeight);
        int i = 0;
        for (; i < list.size(); i++) {
            if (num < list.get(i).weight) break;
        }

        return list.get(i).value;
    }

    public int randomSelectWithBST(List<Pair> list) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("The input is empty");
        int n = list.size();
        int[] weights = new int[n];
        int[] values = new int[n];
        int totalWeight = 0;
        for (int i = 0; i < n; i++) {
            Pair pair = list.get(i);
            totalWeight += pair.weight;
            weights[i] = totalWeight;
            values[i] = pair.value;
        }

        Random rand = new Random();
        int num = rand.nextInt(totalWeight);
        int index = binarySearch(weights, num);
        return values[index];

    }

    private int binarySearch(int[] arr, int value) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            //if (arr[m] == value) return m;
            if (arr[m] < value) s = m + 1;
            else e = m;
        }

        return arr[s] < value ? s + 1 : s;
    }
}


