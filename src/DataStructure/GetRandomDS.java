package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Gavin on 4/12/2015.
 * Design a data structure that supports the following operations:
 * <p/>
 * insert(val) - Inserts val into the data structure.
 * remove(val) - Remove val from the data structure.
 * getRandom() - Returns a random element from the data structure.
 * <p/>
 * Solution: Modified BST which could get rank, all three operations takes O(logn) time
 * Array: Insert O(1), remove O(n), getRandom O(1)
 * Array and HashMap: Insert O(1), remove O(1), getRandom O(1)
 */
public class GetRandomDS {
    int index = -1; //indicate index of the last element in the list
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public void insert(int val)
    {
        if (!map.containsKey(val)) map.put(val, new ArrayList<Integer>());
        ArrayList<Integer> indices = map.get(val);
        indices.add(++index);
        list.set(index, val);
    }

    public void remove(int val)
    {
        if (!map.containsKey(val) || index == -1) return;
        int removeIndex = map.get(val).get(0);
        swap(list, removeIndex, index);
        index--;
    }

    private void swap(ArrayList<Integer> list, int i, int j)
    {
        if (i != j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public int getRandom() throws Exception
    {
        if (index == -1) throw new Exception("There is no record.");
        Random rand = new Random();
        int randomIndex = rand.nextInt(index + 1);
        return list.get(randomIndex);
    }
}
