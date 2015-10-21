package Strings;

import java.util.*;

/**
 * Created by ZXM on 10/21/15.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if (! map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            List<String> list = map.get(sortedStr);
            list.add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }

        return res;
    }
}
